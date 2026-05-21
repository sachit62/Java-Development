package com.sachit.jdbcLearning;

import java.sql.*;
import java.util.Scanner;

public class LaunchApp3 {

    public static void main(String[] args) throws Exception {

        // Load Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connection Details
        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        String user = "root";
        String pass = "root";

        // Establish Connection
        Connection conn = DriverManager.getConnection(url, user, pass);

        Scanner sc = new Scanner(System.in);

        // User Input
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter City: ");
        String city = sc.nextLine();

        // SQL Query with placeholders
        String sql = "INSERT INTO studentInfo(id, sname, sage, scity) VALUES(?, ?, ?, ?)";

        // Create PreparedStatement
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // Set values
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.setInt(3, age);
        pstmt.setString(4, city);

        // Execute
        int rowsAffected = pstmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Data Inserted Successfully");
        } else {
            System.out.println("Insert Failed");
        }

        // Close Resources
        pstmt.close();
        conn.close();
        sc.close();
    }
}