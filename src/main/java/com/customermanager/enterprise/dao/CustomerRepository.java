package com.customermanager.enterprise.dao;

import com.customermanager.enterprise.dto.CustomerDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * We created a CustomerRepository interface, which is code we need for the data access layer.
 * We declared an interface that extends the CrudRepository interface, which defines CRUD methods like save(), findAll(), findById(),deleteById(), etc.
 * At runtime, Spring JPA automatically generates the implementation code.
 */
public interface CustomerRepository extends CrudRepository<CustomerDTO, Integer> {

}