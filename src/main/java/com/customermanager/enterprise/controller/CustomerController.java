package com.customermanager.enterprise.controller;

import com.customermanager.enterprise.dto.CustomerDTO;
import com.customermanager.enterprise.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * This class handles all requests from the clients.
 * The customer manager application features include: displaying all customers, creating a new customer, edit customer info, delete customers, and search for customers.
 */
@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    // display list of Customers
    @GetMapping("/")
    public String viewHomePage(Model model) throws Exception {
        model.addAttribute("listCustomer", customerService.getAllCustomers());
        return "index";
    }
    @GetMapping("/showNewCustomerForm")
    public String showNewCustomerForm(Model model) {
        // create model attribute to bind form data
        CustomerDTO customer = new CustomerDTO();
        model.addAttribute("customer", customer);
        return "new_customer";
    }
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") CustomerDTO customer) throws Exception {
        // save employee to database
        customerService.save(customer);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") int id, Model model) {

        // get customer from the service
        CustomerDTO customer = customerService.getCustomerById(id);

        // set customer as a model attribute to pre-populate the form
        model.addAttribute("customer", customer);
        return "edit_customer";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") int id) {

        // call delete customer method
        this.customerService.delete(id);
        return "redirect:/";
    }
    @GetMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<CustomerDTO> result = customerService.search(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);

        return mav;
    }
}