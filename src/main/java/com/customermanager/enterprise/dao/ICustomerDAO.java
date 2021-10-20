package com.customermanager.enterprise.dao;

import com.customermanager.enterprise.dto.CustomerDTO;

import java.util.List;

public interface ICustomerDAO {
    CustomerDTO getCustomerById(int customerId);

    Iterable<CustomerDTO> getAll() throws Exception;

    boolean save(CustomerDTO customerDTO) throws Exception;
}
