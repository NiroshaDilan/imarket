package lk.imarket.service;

import java.util.List;
import lk.imarket.dto.CustomerDto;

/**
 *
 * @author Hp
 */
public interface CustomerService {
    int addCustomer(CustomerDto customerDto);
    
    List<CustomerDto> getAllCustomers();
    
    CustomerDto getCustomerByNic(String nic);
    
    CustomerDto getCustomerById(int id);
    
    int updateCustomerByNic(String nic);
    
    int deleteCustomerByNic(String nic);
    
    int deleteCustomerById(int id);
}
