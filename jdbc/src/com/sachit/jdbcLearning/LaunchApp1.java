package com.sachit.jdbcLearning; 
import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class LaunchApp1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // Load Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connection Details
        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        String user = "root";
        String pass = "root";

        Connection conn = DriverManager.getConnection(url, user, pass);
        Statement stmt = conn.createStatement();
        Scanner sc = new Scanner(System.in);

        System.out.println("===== JDBC CRUD OPERATIONS =====");
        System.out.println("1. Insert Data");
        System.out.println("2. Read Data");
        System.out.println("3. Update Data");
        System.out.println("4. Delete Data");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();

        switch (choice) {

            // CREATE
            case 1:
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

                String insertQuery = "INSERT INTO studentInfo VALUES(" + id + ",'" + name + "'," + age + ",'" + city + "')";
                int insertResult = stmt.executeUpdate(insertQuery);

                if (insertResult > 0)
                    System.out.println("Data Inserted Successfully");
                else
                    System.out.println("Insert Failed");
                break;

            // READ
            case 2:
                String readQuery = "SELECT * FROM studentInfo";
                ResultSet rs = stmt.executeQuery(readQuery);

                System.out.println("\nStudent Records:");
                while (rs.next()) {
                    System.out.println(
                            rs.getInt("id") + " | " +    // column no. or column name(here used)
                            rs.getString("sname") + " | " +
                            rs.getInt("sage") + " | " +
                            rs.getString("scity"));
                }
                rs.close();
                break;

            // UPDATE
            case 3:
                System.out.print("Enter Student ID to Update: ");
                int updateId = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New City: ");
                String newCity = sc.nextLine();

                String updateQuery = "UPDATE studentInfo SET scity='" + newCity + "' WHERE id=" + updateId;
                int updateResult = stmt.executeUpdate(updateQuery);

                if (updateResult > 0)
                    System.out.println("Data Updated Successfully");
                else
                    System.out.println("Update Failed");
                break;

            // DELETE
            case 4:
                System.out.print("Enter Student ID to Delete: ");
                int deleteId = sc.nextInt();

                String deleteQuery = "DELETE FROM studentInfo WHERE id=" + deleteId;
                int deleteResult = stmt.executeUpdate(deleteQuery);

                if (deleteResult > 0)
                    System.out.println("Data Deleted Successfully");
                else
                    System.out.println("Delete Failed");
                break;

            default:
                System.out.println("Invalid Choice");
        }

        // Close Resources
        stmt.close();
        conn.close();
        sc.close();
        
        
        // use try, catch finally instead of throws keyword
    }
}