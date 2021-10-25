package com.customermanager.enterprise;

import com.customermanager.enterprise.dao.CustomerRepository;
import com.customermanager.enterprise.dto.CustomerDTO;
import com.customermanager.enterprise.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
class CustomerManagerApplicationTests {

    @MockBean
    private CustomerService customerService;
    private CustomerDTO customer= new CustomerDTO();
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

    // Populates the CustomerDTO model
    private void whenSelectingCreateNewCustomer() {
        customer.setId(3);
        customer.setFirstName("James");
        customer.setLastName("Hill");
        customer.setEmail("James.Hill@gmail.com");
        customer.setAddress("444 Mont St, Cincinnati, Ohio 45454");

    }

    // Creates a customer and saves it to the repository,
    // then checks if the saved customer returns correctly from the repository
    private void thenAddNewCustomerInformation() {
       CustomerDTO createCustomer = customerRepository.save(customer);
       assertEquals(customer, createCustomer);
       verify(customerRepository, atLeastOnce()).save(customer);
    }

    // Given CustomerDTO -> Populate CustomerDTO model -> Verify customer saves correctly
    @Test
    void saveCustomerUpdate_displayCustomerUpdate(){
        givenCustomerUpdate();
        whenCustomerUpdate();
        thenCustomerUpdate();
    }

    private void givenCustomerUpdate() {
    }
    //Don't know if this is correct
    private void whenCustomerUpdate() {
        customer.setId(3);
        customer.setFirstName("James");
        customer.setLastName("Hill");
        customer.setEmail("James.Hill@gmail.com");
        customer.setAddress("789 Bill Rd, Cincinnati, Ohio 45434");

    }
    //Don't know if this is correct
    private void thenCustomerUpdate() {
        customerRepository.save(customer);
        var updateCustomer = customerRepository.findById(customer.getId());
        assertEquals(customer, updateCustomer);
        verify(customerRepository, atLeastOnce()).save(customer);
    }

    //Don't know if this is correct for the search
    @Test
    void fetchCustomerByID_returnsCustomerID3() throws Exception  {
        givenCustomerDataAreAvailable();
        whenCustomer3AddedIsJason();
        whenSearchCustomerWithID3();
        thenReturnCustomerID3();
    }

    private void whenCustomer3AddedIsJason() {
        CustomerDTO customerJ = new CustomerDTO();
        customerJ.setId(3);
        customerJ.setFirstName("Jason");
   /*     Mockito.when(customerRepository.findById(3)).thenReturn(customerJ);*/
    }
    //error occurs here??
    private void givenCustomerDataAreAvailable() throws Exception {
        Mockito.when(customerRepository.save(customer)).thenReturn(customer);
    }

    private void whenSearchCustomerWithID3() {
        customer = customerService.getCustomerById(3);
    }

    private void thenReturnCustomerID3() {
        String firstname = customer.getFirstName();
        assertEquals("James", firstname);
    }


}

