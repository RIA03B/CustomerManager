package com.customermanager.enterprise.controller;

import com.customermanager.enterprise.dto.Customer;
import com.customermanager.enterprise.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    // display list of Customers
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listCustomer", customerService.getAllCustomers());
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
    public String saveEmployee(@ModelAttribute("customer") Customer customer) {
        // save employee to database
        customerService.save(customer);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") long id, Model model) {

        // get customer from the service
        Customer customer = customerService.get(id);

        // set customer as a model attribute to pre-populate the form
        model.addAttribute("customer", customer);
        return "edit_customer";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") long id) {

        // call delete customer method
        this.customerService.delete(id);
        return "redirect:/";
    }
    @GetMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Customer> result = customerService.search(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);

        return mav;
    }
}