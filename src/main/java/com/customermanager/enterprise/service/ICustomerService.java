package com.customermanager.enterprise.service;

import com.customermanager.enterprise.dto.Customer;
import java.util.List;

public interface ICustomerService {
    /**
     * Get a Customer info with a given ID
     * @return suitable customer info with a keyword, or nothing if no matches found
     */
    List<Customer> getAllCustomers();
    void save(Customer customer) throws Exception;
    Customer get(long id);
    void delete(long id) throws Exception;
    List<Customer> search(String keyword);

}