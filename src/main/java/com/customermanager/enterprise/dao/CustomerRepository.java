package com.customermanager.enterprise.dao;

import com.customermanager.enterprise.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
      List<Customer> search(@Param("keyword") String keyword);
}