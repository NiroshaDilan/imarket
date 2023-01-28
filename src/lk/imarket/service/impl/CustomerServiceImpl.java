package lk.imarket.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.imarket.dto.CustomerDto;
import lk.imarket.repository.CustomerRepository;
import lk.imarket.repository.impl.CustomerRepositoryImpl;
import lk.imarket.service.CustomerService;

/**
 *
 * @author Hp
 */
public class CustomerServiceImpl implements CustomerService {
    
    private CustomerRepository customerRepository;
   
    @Override
    public int addCustomer(CustomerDto customerDto) {
        try {
            customerRepository = new CustomerRepositoryImpl();
            return customerRepository.addCustomer(customerDto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        try {
            customerRepository = new CustomerRepositoryImpl();
            return customerRepository.getAllCustomers();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }

    @Override
    public CustomerDto getCustomerByNic(String nic) {
        try {
            customerRepository = new CustomerRepositoryImpl();
            return customerRepository.getCustomerByNic(nic);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public CustomerDto getCustomerById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateCustomerByNic(String nic) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteCustomerByNic(String nic) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteCustomerById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
