package com.vinson.sms;

import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {
    static Connection conn;
    static PreparedStatement pst;

    public static int insertStudent(StudentBean u){
        int status = 0;
        String sql = "INSERT INTO studentinformation(\"Stu_Name\", \"Stu_Reg_No\", \"Stu_Phone\")" + "VALUES (?, ?, ?)";
        try{
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement(sql);
            pst.setString(1, u.getName());
            pst.setString(2, u.getRegno());
            pst.setString(3, u.getPhno());
            status = pst.executeUpdate();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return status;
    }

    public static int deleteStudent(StudentBean u){
        int status = 0;
        String sql = "DELETE FROM studentinformation WHERE Stu_Reg_No = ?";
        try{
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement(sql);
            pst.setString(1, u.getRegno());
            status = pst.executeUpdate();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return status;
    }

    public static int updateStudent(StudentBean u){
        int status=0;
        try {
            conn=ConnectionProvider.getCon();
            pst= conn.prepareStatement("update studentinformation set Stu_Name=?, Stu_Phone=? where Stu_Reg_No=?");
            pst.setString(1, u.getName());
            pst.setString(2, u.getPhno());
            pst.setString(3, u.getRegno());
            status=pst.executeUpdate();
            conn.close();
        }catch(Exception e) {
            System.out.println(e);
        }
        return status;
    }

}
