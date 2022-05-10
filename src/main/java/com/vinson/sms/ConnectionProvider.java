package com.vinson.sms;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider implements Provider {
    static Connection con = null;
    public static Connection getCon(){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the Database");
        }
        catch (Exception e){
            System.out.println(e);
        }
        return con;
    }
}