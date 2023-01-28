/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.imarket.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lk.imarket.db.DBConnection;
import lk.imarket.dto.CustomerDto;
import lk.imarket.dto.ProductDto;


/**
 *
 * @author Hp
 */
public class ProductRepositoryImpl{
    public List<ProductDto> getAllProducts() {
        List<ProductDto> dtoList = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try (Connection con = new DBConnection().getConnection()) {

            Statement createStatement = con.createStatement();
            ResultSet rs = createStatement.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                ProductDto dto = new ProductDto();

                dto.setProductCode(rs.getString("product_code"));
                dto.setProductName(rs.getString("product_name"));
                dto.setProductDescription(
                        rs.getString("product_desc"));
                dto.setQty(rs.getInt("qty"));
                dto.setBuyPrice(rs.getDouble("buy_price"));
                dto.setMsrp(rs.getDouble("msrp"));
                
                dtoList.add(dto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return dtoList;
    }
    
    public ProductDto getProductByCode(String code) throws SQLException {
        String sql = " SELECT * FROM product WHERE product_code = ?";

        try (Connection con = new DBConnection().getConnection(); 
                PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, code);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                ProductDto dto = new ProductDto();

                dto.setProductCode(rs.getString("product_code"));
                dto.setProductName(rs.getString("product_name"));
                dto.setProductDescription(
                        rs.getString("product_desc"));
                dto.setQty(rs.getInt("qty"));
                dto.setBuyPrice(rs.getDouble("buy_price"));
                dto.setMsrp(rs.getDouble("msrp"));

                return dto;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
