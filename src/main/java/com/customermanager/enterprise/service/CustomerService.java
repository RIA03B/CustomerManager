package com.customermanager.enterprise.service;


import java.util.List;
import java.util.Optional;
import com.customermanager.enterprise.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.customermanager.enterprise.dto.Customer;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }
    @Override
    public Customer get(long id) {
        Optional < Customer > optional = customerRepository.findById(id);
        Customer customer;
        if (optional.isPresent()) {
            customer = optional.get();
        } else {
            throw new RuntimeException(" Customer not found for id :: " + id);
        }
        return customer;
    }
    @Override
    public void delete(long id) {
        this.customerRepository.deleteById(id);
    }


    public List<Customer> search(String keyword) {
        return customerRepository.search(keyword);
    }


}