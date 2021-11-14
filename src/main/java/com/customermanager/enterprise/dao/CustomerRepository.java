package com.customermanager.enterprise.dao;

import com.customermanager.enterprise.dto.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * We created a CustomerRepository interface, which is code we need for the data access layer.
 * We declared an interface that extends the CrudRepository interface, which defines CRUD methods like save(), findAll(), findById(),deleteById(), etc.
 * At runtime, Spring JPA automatically generates the implementation code.
 */
@Repository("CustomerRepository")
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}