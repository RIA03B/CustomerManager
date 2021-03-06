package com.customermanager.enterprise.service;

import java.util.List;
import com.customermanager.enterprise.dao.CustomerRepository;

import org.springframework.cache.annotation.CacheEvict;
import com.customermanager.enterprise.dao.ICustomerDAO;
import com.customermanager.enterprise.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class defines the application's boundary. It is a set of available
 * operations from the perspective of interfacing client layers. It encapsulates
 * the application's business logic, controlling transactions and coordinates
 * responses in the implementation of its operations.
 *
 * @author Rania Ibrahim, Christian Turner, Elijah Klopfstein
 */
@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerDAO customerDAO;

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(ICustomerDAO customerDAO)
    {
        this.customerDAO = customerDAO;
    }

    @Override
    public Iterable<Customer> fetchAll() throws Exception {
        return customerDAO.fetchAll();
    }

    @Override
    public Customer save(Customer customer) throws Exception {
        return customerDAO.save(customer);
    }

    @Override
    public Customer fetch(int id) {
        return customerDAO.fetch(id);
    }

    @Override
    @CacheEvict(value = "delete", key = "#id")
    public void delete(int id) {
        this.customerRepository.deleteById(id);
    }
}