package com.customermanager.enterprise.dao;

import com.customermanager.enterprise.dto.Customer;

import java.util.List;

public interface ICustomerDAO {
    void save(Customer customer) throws Exception;
    List<Customer> getAllCustomers();
}
