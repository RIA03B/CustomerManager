package com.customermanager.enterprise.dao;

import com.customermanager.enterprise.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAO implements ICustomerDAO{
    Map<Integer, Customer> allCustomers = new HashMap<>();

    @Autowired
    @Qualifier("customerRepository")
    CustomerRepository customerRepository;

    @Override
    public Customer fetch(int customerId) {
        return customerRepository.findById(customerId).get();
    }

    @Override
    public Iterable<Customer> fetchAll() throws Exception {
        return customerRepository.findAll();
    }

    @Override
    public Customer save(Customer customer) throws Exception {
        Customer save = customerRepository.save(customer);
        return save;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> allCustomerList = new ArrayList<>(allCustomers.values());
        return  allCustomerList;
    }
}
