package com.vinson.sms;

import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {
    static Connection conn;
    static PreparedStatement pst;

    public static int insertStudent(StudentBean u){
        int status = 0;
        String sql = "INSERT INTO studentdetails(\"regno\", \"name\", \"phone\")" + "VALUES (?, ?, ?)";
        try{
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, u.getRegno());
            pst.setString(2, u.getName());
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
        String sql = "DELETE FROM studentdetails WHERE regno = ?";
        try{
            conn = ConnectionProvider.getCon();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, u.getRegno());
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
            String a = u.getName();
            String b = u.getPhno();
            int c = u.getRegno();
            System.out.println(a+b+c);
            if (a!=null && b==null && c!=0){
                pst= conn.prepareStatement("update studentdetails set name=? where regno=?");
                pst.setString(1, u.getName());
                pst.setInt(2, u.getRegno());
                status=pst.executeUpdate();
                conn.close();
                System.out.println("a executed");
            } else if (a==null && b!=null && c!=0) {
                pst= conn.prepareStatement("update studentdetails set phone=? where regno=?");
                pst.setString(1, u.getPhno());
                pst.setInt(2, u.getRegno());
                status=pst.executeUpdate();
                conn.close();
                System.out.println("b executed");
            }
            else {
                pst= conn.prepareStatement("update studentdetails set name=?, phone=? where regno=?");
                pst.setString(1, u.getName());
                pst.setString(2, u.getPhno());
                pst.setInt(3, u.getRegno());
                status=pst.executeUpdate();
                conn.close();
                System.out.println("c executed");
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
