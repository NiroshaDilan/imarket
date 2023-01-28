/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.imarket.repository;

import java.util.List;
import lk.imarket.dto.CustomerDto;
import java.sql.SQLException;
/**
 *
 * @author Hp
 */
public interface CustomerRepository {
    int addCustomer(CustomerDto customerDto) throws SQLException;
    
    List<CustomerDto> getAllCustomers() throws SQLException;
    
    CustomerDto getCustomerByNic(String nic) throws SQLException;
    
    CustomerDto getCustomerById(int id) throws SQLException;
    
    int updateCustomerByNic(String nic) throws SQLException;
    
    int deleteCustomerByNic(String nic) throws SQLException;
    
    int deleteCustomerById(int id) throws SQLException;
    
}
