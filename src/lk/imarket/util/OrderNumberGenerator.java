/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.imarket.util;

import java.sql.SQLException;
import lk.imarket.repository.OrderRepository;

/**
 *
 * @author Hp
 */
public class OrderNumberGenerator {
    
    private static OrderRepository orderRepository;
    
    private OrderNumberGenerator(){}
    
    public static String getLatestOrderNumber() {
        String latestOrder = null;
        orderRepository = new OrderRepository();
        
        try {
            String maxNumber = orderRepository.getMaxOrderNumber();
            if (maxNumber != null) {
                int id = Integer
                        .parseInt(maxNumber.substring(2, 
                                maxNumber.length()));
                latestOrder = "E-" + String.format("%07d", ++id);
            } else {
                latestOrder = "E-00000001";
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return latestOrder;
    }
   
}
