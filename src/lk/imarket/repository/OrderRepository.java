/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.imarket.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import lk.imarket.db.DBConnection;

/**
 *
 * @author Hp
 */
public class OrderRepository {
    public String getMaxOrderNumber() throws SQLException {
        String lastNumber = null;
        ResultSet rs = null;
        Statement statement = null;
        String sql = "SELECT MAX(order_number) from orders";
        try (Connection con = new DBConnection().getConnection()) {
            statement = con.createStatement();
            rs = statement.executeQuery(sql);
            
            if (rs.next()) {
                return lastNumber = rs.getString("MAX(order_number)");
            } 
            
        } finally {
            if (rs != null) rs.close();
            if (statement != null) statement.close();
        }
        return lastNumber;  
    }
}
