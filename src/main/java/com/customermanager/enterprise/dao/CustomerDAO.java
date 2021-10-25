package com.customermanager.enterprise.dao;

import com.customermanager.enterprise.dao.CustomerRepository;
import com.customermanager.enterprise.dao.ICustomerDAO;
import com.customermanager.enterprise.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAO implements ICustomerDAO {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean save(CustomerDTO customerDTO) throws Exception {
        customerRepository.save(customerDTO);
        return false;
    }

    @Override
    public Iterable<CustomerDTO> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        return customerRepository.findById(customerId).get();
    }
}
