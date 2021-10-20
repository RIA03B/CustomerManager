package com.customermanager.enterprise.service;

import com.customermanager.enterprise.dto.CustomerDTO;
import java.util.List;

public interface ICustomerService {
    Iterable<CustomerDTO> getAllCustomers() throws Exception;

    boolean save(CustomerDTO customer) throws Exception;

    CustomerDTO getCustomerById(int id);

    void delete(int id);

    List<CustomerDTO> search(String keyword);

}