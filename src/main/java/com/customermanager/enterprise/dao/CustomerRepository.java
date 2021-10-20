package com.customermanager.enterprise.dao;

import com.customermanager.enterprise.dto.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerDTO, Integer> {
      List<CustomerDTO> search(@Param("keyword") String keyword);

      CustomerDTO getCustomerById(int customerId);
}