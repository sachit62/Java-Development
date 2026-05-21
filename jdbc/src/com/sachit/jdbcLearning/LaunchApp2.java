package com.sachit.jdbcLearning; 
import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class LaunchApp2 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // Load Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connection Details
        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        String user = "root";
        String pass = "root";

        Connection conn = DriverManager.getConnection(url, user, pass);
        Statement stmt = conn.createStatement();
       
        // execute
        String sql = "SELECT * FROM studentInfo";
        boolean status = stmt.execute(sql);
        
        // process the result
        if(status) {
        	// select
        	
        } else {
        	// insert, update, delete
        	
        }
        
        // Close Resources
        stmt.close();
        conn.close();
    }
}