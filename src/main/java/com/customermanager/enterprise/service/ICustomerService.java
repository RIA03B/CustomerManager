package com.customermanager.enterprise.service;

import com.customermanager.enterprise.dto.Customer;

/**
 * Customer Service handles logic for Customer DTO.
 * This interface returns all saved customers, saves a new customer, deletes a customer, and searches for a customer.
 */
public interface ICustomerService {
    Iterable<Customer> fetchAll() throws Exception;

    Customer save(Customer customer) throws Exception;

    Customer fetch(int id);

    void delete(int id) throws Exception;


}