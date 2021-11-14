package com.customermanager.enterprise.dao;

import com.customermanager.enterprise.dto.Customer;

import java.util.List;

public interface ICustomerDAO {
    Customer fetch(int customerId);

    Iterable<Customer> fetchAll() throws Exception;

    Customer save(Customer customer) throws Exception;
}
