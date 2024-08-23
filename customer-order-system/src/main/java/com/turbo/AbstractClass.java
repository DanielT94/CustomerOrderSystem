package com.turbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping;


//Abstract class that will connect to DB
public abstract class AbstractClass {

    //Establish connection to DB
    protected Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/customer_order_system";
        String user = "root";
        String password = "password";

        return DriverManager.getConnection(url, user, password);
    }

    public void testConnection() {
        try (Connection conn = getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Database connection successful!");
            } else {
                System.out.println("Database connection failed!");
            }
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }

    public void create(String sql, String name) {
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.executeUpdate();
                System.out.println("Successfully Created");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
