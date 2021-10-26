package com.customermanager.enterprise.service;

import com.customermanager.enterprise.dto.Customer;
import java.util.List;
/**
 * Customer Service handles logic for Customer DTO.
 * This interface returns all saved customers, saves a new customer, deletes a customer, and searches for a customer.
 * @author Rania Ibrahim, Christian Turner, Elijah Klopfstein
 */
public interface ICustomerService {
    List<Customer> getAllCustomers();
    void save(Customer customer);
    Customer get(long id);
    void delete(long id);
    List<Customer> search(String keyword);

}