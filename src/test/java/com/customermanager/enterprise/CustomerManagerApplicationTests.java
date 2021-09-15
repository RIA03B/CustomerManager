package com.customermanager.enterprise;

import com.customermanager.enterprise.dao.CustomerRepository;
import com.customermanager.enterprise.dto.Customer;
import com.customermanager.enterprise.service.CustomerService;
import com.customermanager.enterprise.service.ICustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
class CustomerManagerApplicationTests {


    private ICustomerService customerService;
    private Customer customer= new Customer();
    @MockBean
    private CustomerRepository customerRepository;

    @Test
    void contextLoads() {
    }
    @Test
    void addNewCustomer_displayNewCustomer(){
        givenNewCustomerTabIsAvailable();
        whenSelectingCreateNewCustomer();
        thenAddNewCustomerInformation();
    }

    private void givenNewCustomerTabIsAvailable() {
    }

    private void whenSelectingCreateNewCustomer() {
        customer.setId(3L);
        customer.setFirstName("James");
        customer.setLastName("Hill");
        customer.setEmail("James.Hill@gmail.com");
        customer.setAddress("444 Mont St, Cincinnati, Ohio 45454");

    }

    private void thenAddNewCustomerInformation() {
       Customer createCustomer = customerRepository.save(customer);
       assertEquals(customer, createCustomer);
       verify(customerRepository, atLeastOnce()).save(customer);
    }

    @Test
    void thisTest_ShouldFail() {
        assertEquals(4, 2+2);
    }

}

