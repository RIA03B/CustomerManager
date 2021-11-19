package com.customermanager.enterprise.controller;

import com.customermanager.enterprise.dto.Customer;
import com.customermanager.enterprise.service.ICustomerService;
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
    public String saveCustomer(@ModelAttribute("customer") Customer customer) throws Exception {
        customerService.save(customer);
        return "redirect:/";
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


    /**
     * Search for a customer
     *
     * @return customer that was searched for.
     */
    @GetMapping("/search")
    public ResponseEntity search(@RequestParam(value="keyword",required = false,defaultValue = "None") String keyword){
        String newSearch = keyword + "";
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/Customer")
    public ResponseEntity fetchAllCustomers(){
        try {
            List<Customer> allCustomers = customerService.getAllCustomers();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity(allCustomers, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}