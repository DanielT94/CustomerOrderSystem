package com.turbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.turbo.AbstractClass.ResultSetProcessor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public void create(String sql, Object... params) { //abstract create method handles database connection
        try (Connection conn = getConnection(); //open database connection
            PreparedStatement pstmt = conn.prepareStatement(sql)) { //prepare the SQL statement
                for (int i = 0; i < params.length; i++) {
                    if (params[i] instanceof String) { //if string then use this
                        pstmt.setString(i + 1, (String) params[i]);
                    } else if (params[i] instanceof Double) { //if double use this
                        pstmt.setDouble(i + 1, (Double) params[i]);
                    } else if (params[i] instanceof Integer) { //if integer use this
                        pstmt.setInt(i + 1, (Integer) params[i]);
                    }    
                }
                pstmt.executeUpdate(); //execute SQL statement
                System.out.println("Successfully Created"); //output if successful
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage()); //output if error
        }
    }

    public void read(String sql, ResultSetProcessor processor) { //abstract read method 
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) { //execute SQL and get result set
            while (rs.next()) { //iterate over each row in rs
                processor.process(rs); //process rs
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Interface for processing ResultSet
    public interface ResultSetProcessor {
        void process(ResultSet rs) throws SQLException;
    }

    public void update(String sql, Object... params) { //abstract update method
        try (Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) { //runs through each parameter passed in to update
                pstmt.setObject(i + 1, params[i]); //set each parameter in SQL query
            }
            int rowsAffected = pstmt.executeUpdate(); //executes SQL query
            System.out.println("Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void delete(String sql, int... params) { // abstract delete method
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {            
            for (int i = 0; i < params.length; i++) {
                pstmt.setInt(i + 1, params[i]);
            }
            int rowsAffected = pstmt.executeUpdate(); // execute the delete command
            System.out.println("Delete successful, rows affected: " + rowsAffected);           
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage()); // log SQL exceptions
        }
    }
}
