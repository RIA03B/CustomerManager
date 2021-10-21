package com.customermanager.enterprise.service;

import java.util.List;
import java.util.Optional;

import com.customermanager.enterprise.dao.CustomerDAO;
import com.customermanager.enterprise.dao.CustomerRepository;
import com.customermanager.enterprise.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class defines the application's boundary.
 * It is a set of available operations from the perspective of interfacing client layers.
 * It encapsulates the application's business logic, controlling transactions and coordinates responses in the implementation of its operations.
 */
@Service

public class CustomerService implements ICustomerService {
    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
    }

    @Override
    public Iterable<CustomerDTO> getAllCustomers() throws Exception {
        return customerDAO.getAll();
    }

    @Override
    public boolean save(CustomerDTO customer) throws Exception {
        customerDAO.save(customer);
        return false;
    }

    @Override
    public CustomerDTO getCustomerById(int id) {
        Optional <CustomerDTO> optional = customerRepository.findById(id);
        CustomerDTO customer;
        if (optional.isPresent()) {
            customer = optional.get();
        } else {
            throw new RuntimeException(" CustomerDTO not found for id :: " + id);
        }
        return customer;
    }

    @Override
    public void delete(int id) {
        this.customerRepository.deleteById(id);
    }

    public List<CustomerDTO> search(String keyword) {
        return customerRepository.search(keyword);
    }
}