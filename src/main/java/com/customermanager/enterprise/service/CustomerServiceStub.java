package com.customermanager.enterprise.service;

import com.customermanager.enterprise.dao.ICustomerDAO;
import com.customermanager.enterprise.dto.CustomerDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerServiceStub implements ICustomerService {
    private ICustomerDAO customerDAO;


    @Override
    public Iterable<CustomerDTO> getAllCustomers() throws Exception {
        return null;
    }

    @Override
    public boolean save(CustomerDTO customer) throws Exception {
        return false;
    }

    @Override
    public CustomerDTO getCustomerById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<CustomerDTO> search(String keyword) {
        return null;
    }
}
