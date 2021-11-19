package com.customermanager.enterprise.service;

import com.customermanager.enterprise.dto.Customer;
import java.util.List;


/**
 * Customer Service handles logic for Customer DTO. This interface returns all
 * saved customers, saves a new customer, deletes a customer, and searches for a
 * customer.
 *
 * @author Rania Ibrahim, Christian Turner, Elijah Klopfstein
 */
public interface ICustomerService {
    Iterable<Customer> fetchAll() throws Exception;

    Customer save(Customer customer) throws Exception;

    Customer fetch(int id);

    void delete(int id) throws Exception;

    List<Customer> getAllCustomers();
}