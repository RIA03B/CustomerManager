package com.customermanager.enterprise.controller;

import com.customermanager.enterprise.dto.Customer;
import com.customermanager.enterprise.service.ICustomerService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpHeaders;
import java.util.List;

/**
 * This class handles all requests from the clients. The customer manager
 * application features include: displaying all customers, creating a new
 * customer, edit customer info, delete customers, and search for customers.
 *
 * @author Rania Ibrahim, Christian Turner, Elijah Klopfstein
 */
@Controller
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    /**
     * Display list of Customers
     *
     * @return main index page
     */
    @GetMapping("/")
    public String viewHomePage(Model model) throws Exception {
        model.addAttribute("listCustomer", customerService.fetchAll());
        return "index";
    }

    /**
     * Display New Customer form
     *
     * @return new customer page
     */
    @GetMapping("/showNewCustomerForm")
    public String showNewCustomerForm(Model model) {
        // create model attribute to bind form data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new_customer";
    }

    /**
     * Save customer to database
     *
     * @return Save customer then redirect them to the main page
     */
    @PostMapping("/save")
    public String save(@ModelAttribute("customer") Customer customer) throws Exception {
        customerService.save(customer);
        return "redirect:/";
    }

    /**
     * Create a customer, given provided data
     *
     * @param customer JSON Object
     * @return New customer object
     */
    @PostMapping("/createCustomer")
    public ResponseEntity createCustomer(@RequestBody Customer customer) throws Exception {
        Customer newCustomer = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            newCustomer = customerService.save(customer);
        } catch (Exception e) {
            return new ResponseEntity(headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(newCustomer, headers, HttpStatus.OK);
    }

    /**
     * Create a customer, given provided data
     *
     * @param customer JSON Object
     * @return New customer object
     */
    @PostMapping("/saveCustomer/{id}")
    public ResponseEntity saveCustomer(@PathVariable("id") int id, @RequestBody Customer customer) throws Exception {
        Customer newCustomer = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            customer.setId(id);
            newCustomer = customerService.save(customer);
        } catch (Exception e) {
            return new ResponseEntity(headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(newCustomer, headers, HttpStatus.OK);
    }

    /**
     * Delete a customer, given provided id
     *
     * @param id id
     */
    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity deleteCustomer(@PathVariable("id") int id) throws Exception {
        try {
            customerService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get customer from the service. Set customer as a model attribute to
     * pre-populate the form
     *
     * @return edit customer page
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") int id, Model model) {

        // get customer from the service
        Customer customer = customerService.fetch(id);

        // set customer as a model attribute to pre-populate the form
        model.addAttribute("customer", customer);
        return "edit_customer";
    }

    /**
     * Delete Customer
     *
     * @return Delete customer then redirect them to the main page
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") int id) throws Exception {

        // call delete customer method
        this.customerService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/customers")
    @ResponseBody
    public Iterable<Customer> fetchAllCustomers() throws Exception {
        return customerService.fetchAll();
    }
}