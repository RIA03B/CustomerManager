package com.customermanager.enterprise.service;

import com.customermanager.enterprise.dto.Customer;
import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomers();
    void save(Customer customer);
    Customer get(long id);
    void delete(long id);

}