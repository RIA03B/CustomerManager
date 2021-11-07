package com.customermanager.enterprise.service;

import com.customermanager.enterprise.dto.Customer;
import java.util.List;
/**
 * Customer Service handles logic for Customer DTO.
 * This interface returns all saved customers, saves a new customer, deletes a customer, and searches for a customer.
 * @author Rania Ibrahim, Christian Turner, Elijah Klopfstein
 */
public interface ICustomerService {

    /**
     * Return all saved customers.
     * @return a collection of all customer entries.
     */
    List<Customer> getAllCustomers();
    /**
     * Save a new customer
     * @param customer the entry to save.
     * @return a customer object.
     */
    void save(Customer customer) throws Exception;
    /**
     * Return a customer with a given ID.
     * @param id a unique identifier for a specific customer.
     * @return a matching customer, or null if no matches are found.
     */
    Customer get(long id);
    void delete(long id);
    List<Customer> search(String keyword);
}