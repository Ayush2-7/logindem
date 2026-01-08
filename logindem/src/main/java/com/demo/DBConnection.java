package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // 1. Double check your port (default is 3306) and DB name (authdb)
    private static final String URL = "jdbc:mysql://localhost:3306/authdb";
    private static final String USER = "root";
    // 2. THIS MUST MATCH YOUR MYSQL WORKBENCH PASSWORD
    private static final String PASSWORD = "root"; 

    public static Connection getConnection() {
        Connection con = null;
     // Inside DBConnection.java
        try {
            // Make sure ".cj." is included here!
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/authdb", "root", "root");
            System.out.println("Success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            // New driver class name for Connector/J 8.0+
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database Connected Successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("DRIVER ERROR: Did you paste the JAR in WEB-INF/lib?");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL ERROR: Check username/password or if MySQL is running.");
            e.printStackTrace();
        }
        return con;
    }
}