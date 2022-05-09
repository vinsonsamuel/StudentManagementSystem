package com.vinson.sms;

import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.PreparedStatement;

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

    public static int searchStudent(StudentBean u){
        int status = 0;
        String sql = "SELECT * from studentinformation WHERE Stu_Reg_No = ?";
        try{
           conn = ConnectionProvider.getCon();
           pst = conn.prepareStatement(sql);
           System.out.println(pst.execute());
        }
        catch(Exception e){
            System.out.println(e);
        }
        return status;
    }

    public static int updateStudent(StudentBean u){
        int status = 0;
        String sql = "UPDATE studentinformation " + "SET Stu_Name = ?, Stu_Phone = ? "
                + "WHERE Stu_Reg_No = ?";
        try{
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement();
            ResultSet rst = pst.executeQuery(sql)'
            rst.getString("Stu_Name");
            rst.getString("Stu_RegNo");
            rst.getString("Stu_Phone");
            status = pst.executeUpdate();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return status;
    }

}
