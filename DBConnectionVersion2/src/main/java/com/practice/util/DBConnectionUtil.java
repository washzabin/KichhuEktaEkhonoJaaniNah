package com.practice.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	private static final String JDBC_URL_PREFIX = "jdbc:";
	    
	    // Change these values based on your database configuration
	    private static final String DB_URL = "jdbc:postgresql://pg.pg4e.com:5432/pg4e_c3ec4b99d5";
	    private static final String DB_USERNAME = "pg4e_c3ec4b99d5";
	    private static final String DB_PASSWORD = "pg4e_p_656a85128212284";
	
	    public static Connection connectToDatabase() throws SQLException {
	        try {
//	            // Load the JDBC driver class
//	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            // Establish the database connection
	            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	            return connection;
	        } catch (SQLException e) {
	            throw new SQLException("JDBC driver not found", e);
	        }
	    }
	    
	    public static void closeConnection(Connection connection) {
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                // Handle the exception if closing the connection fails
	                e.printStackTrace();
	            }
	        }
	    }
}
