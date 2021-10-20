package com.customermanager.enterprise.dao;

import com.customermanager.enterprise.dao.CustomerRepository;
import com.customermanager.enterprise.dao.ICustomerDAO;
import com.customermanager.enterprise.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDAO implements ICustomerDAO {
    @Autowired
    CustomerRepository customerRepository;

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
        return customerRepository.getCustomerById(customerId);
    }
}
