package com.customermanager.enterprise;

import com.customermanager.enterprise.dao.CustomerRepository;
import com.customermanager.enterprise.dto.Customer;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
class CustomerManagerApplicationTests {

    @MockBean
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

    // Populates the Customer model
    private void whenSelectingCreateNewCustomer() {
        customer.setId(3);
        customer.setFirstName("James");
        customer.setLastName("Hill");
        customer.setEmail("James.Hill@gmail.com");
        customer.setAddress("444 Mont St, Cincinnati, Ohio");

    }

    // Creates a customer and saves it to the repository,
    // then checks if the saved customer returns correctly from the repository
    private void thenAddNewCustomerInformation() {
        Customer createCustomer = customerRepository.save(customer);
        assertEquals(customer, createCustomer);
        verify(customerRepository, atLeastOnce()).save(customer);
    }

    // Given Customer -> Populate Customer model -> Verify customer saves correctly
    @Test
    void saveCustomerUpdate_displayCustomerUpdate(){
        givenCustomerUpdate();
        whenCustomerUpdate();
        thenCustomerUpdate();
    }

    private void givenCustomerUpdate() {
    }
    private void whenCustomerUpdate() {
        customer.setId(3);
        customer.setFirstName("James");
        customer.setLastName("Hill");
        customer.setEmail("James.Hill@gmail.com");
        customer.setAddress("789 Bill Rd, Cincinnati, Ohio");

    }
    private void thenCustomerUpdate() {
        customerRepository.save(customer);
        var updateCustomer = customerRepository.findById(customer.getId());
        assertEquals(customer, updateCustomer);
        verify(customerRepository, atLeastOnce()).save(customer);
    }
}
