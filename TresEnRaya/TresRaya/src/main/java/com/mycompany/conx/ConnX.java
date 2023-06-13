/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author romer
 */
public class ConnX {
    
    private static volatile ConnX instance;
    private static volatile Connection connection;
    
    private ConnX() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
        if (connection != null) {
            throw new RuntimeException("Use getConnection() method to create");
        }
    }
    
    public static ConnX getInstance() {
        if (instance == null) {
            synchronized (ConnX.class) {
                if (instance == null) {
                    instance = new ConnX();
                }
            }
        }
        return instance;
    }
    
    public Connection getConnection() {
        if (connection == null) {
            synchronized (ConnX.class) {
                if (connection == null) {
                    try {
                        String dbUrl = "jdbc:sqlite:data/db_calc.db?foreign_keys=on;";
                        connection = DriverManager.getConnection(dbUrl);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }
    
}
