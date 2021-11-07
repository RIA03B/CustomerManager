package com.customermanager.enterprise.dao;

import com.customermanager.enterprise.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDAO implements ICustomerDAO{


CustomerRepository customerRepository;

    //List<Customer> allCustomers = new ArrayList<>();

    @Override
    public void save(Customer customer) throws Exception{
        customerRepository.save(customer);
        //allCustomers.add(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = new ArrayList<>();
        Iterable<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers){
            allCustomers.add(customer);
        }
        return allCustomers;
    }
}
