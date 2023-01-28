/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.imarket.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hp
 */
public class DBConnection {
   
    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/foodcitydb";
        String user = "root";
        String password = "root";
        
        return DriverManager.getConnection(url, user, password);
    }
}
