package com.customermanager.enterprise.controller;

import com.customermanager.enterprise.dto.Customer;
import com.customermanager.enterprise.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * This class handles all requests from the clients.
 * The customer manager application features include: displaying all customers, creating a new customer, edit customer info, delete customers, and search for customers.
 */
@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    // display list of Customers
    @GetMapping("/")
    public String viewHomePage(Model model) throws Exception {
        model.addAttribute("listCustomer", customerService.fetchAll());
        return "index";
    }
    @GetMapping("/showNewCustomerForm")
    public String showNewCustomerForm(Model model) {
        // create model attribute to bind form data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new_customer";
    }
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) throws Exception {
        // save employee to database
        customerService.save(customer);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") int id, Model model) {

        // get customer from the service
        Customer customer = customerService.fetch(id);

        // set customer as a model attribute to pre-populate the form
        model.addAttribute("customer", customer);
        return "edit_customer";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") int id) throws Exception {

        // call delete customer method
        this.customerService.delete(id);
        return "redirect:/";
    }
 /*   @GetMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Customer> result = customerService.search(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);

        return mav;
    }*/
}