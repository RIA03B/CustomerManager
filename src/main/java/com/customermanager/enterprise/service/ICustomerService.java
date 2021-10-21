package com.customermanager.enterprise.service;

import com.customermanager.enterprise.dto.CustomerDTO;
import java.util.List;
/**
 * Customer Service handles logic for Customer DTO.
 * This interface returns all saved customers, saves a new customer, deletes a customer, and searches for a customer.
 */
public interface ICustomerService {
    Iterable<CustomerDTO> getAllCustomers() throws Exception;

    boolean save(CustomerDTO customer) throws Exception;

    CustomerDTO getCustomerById(int id);

    void delete(int id);

    List<CustomerDTO> search(String keyword);

}