package com.customermanager.enterprise.service;

import com.customermanager.enterprise.dto.Customer;
import java.util.List;


/**
 * Customer Service handles logic for Customer DTO.
 */
public interface ICustomerService {

    /**
     * Return all saved customers.
     * @return a collection of all customer entered.
     */

    List<Customer> getAllCustomers();

    /**
     * Save a new customer
     * @param customer the entry to save.
     */
    void save(Customer customer);


    Customer get(long id);
    void delete(long id);
    List<Customer> search(String keyword);

}