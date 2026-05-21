package com.sachit.jdbcLearning;
import java.sql.*;

public class BatchOperations {

    public static void main(String[] args) throws Exception {

        // Load Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connection Details
        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        String user = "root";
        String pass = "root";

        // Establish Connection
        Connection conn = DriverManager.getConnection(url, user, pass);

        // SQL Query
        String sql = "INSERT INTO studentInfo(id, sname, sage, scity) VALUES(?, ?, ?, ?)";

        // Create PreparedStatement
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // Batch 1
        pstmt.setInt(1, 201);
        pstmt.setString(2, "Rahul");
        pstmt.setInt(3, 21);
        pstmt.setString(4, "Pune");
        pstmt.addBatch();

        // Batch 2
        pstmt.setInt(1, 202);
        pstmt.setString(2, "Amit");
        pstmt.setInt(3, 22);
        pstmt.setString(4, "Mumbai");
        pstmt.addBatch();

        // Batch 3
        pstmt.setInt(1, 203);
        pstmt.setString(2, "Priya");
        pstmt.setInt(3, 20);
        pstmt.setString(4, "Nagpur");
        pstmt.addBatch();

        // Execute Batch
        int[] result = pstmt.executeBatch();

        System.out.println("Batch Executed Successfully");

        for (int i = 0; i < result.length; i++) {
            System.out.println("Rows affected: " + result[i]);
        }

        // Close Resources
        pstmt.close();
        conn.close();
    }
}