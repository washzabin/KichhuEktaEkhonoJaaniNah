package com.practice.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;

import com.practice.util.DBConnectionUtil;

public class App 
{
    public static void main( String[] args )
    {
    	try {
            Connection connection = DBConnectionUtil.connectToDatabase();
            
            // Perform database operations using the connection
            System.out.println("Print something");
            
            DatabaseMetaData metaData = connection.getMetaData();
            
            // Retrieve and display database information
            System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
            System.out.println("Driver Name: " + metaData.getDriverName());
            System.out.println("Driver Version: " + metaData.getDriverVersion());
            
            // Retrieve and display table information
            System.out.println("\nTables in the database:");
            ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println(tableName);
            }
            
            String selectQuery = "SELECT * from ages";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            // Process query results
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }
            
            tables.close();
            resultSet.close();
            preparedStatement.close();
            DBConnectionUtil.closeConnection(connection);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
