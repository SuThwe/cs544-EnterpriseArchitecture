package edu.mum.cs544.controller;

import edu.mum.cs544.model.Customer;
import edu.mum.cs544.service.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customer")
public class CustomerRestController {
    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/", produces = "application/json")
    public List<Customer> getAll(){return customerService.getAll();}
    
    @PostMapping(value = "/add")
    public Customer addCustomer(@RequestBody Customer customer) {
        Customer cus = customerService.addCustomer(customer);
        return cus;
    }

    @GetMapping(value = "/get/{id}")
    public Customer getCustomer(@PathVariable int id) {
        return customerService.getCustomer(id);
    }

    @PostMapping(value = "/update")
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return customer;
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteCustomer(@PathVariable int id) {
        customerService.delete(id);
        return "Customer with id = " + id + " is deleted.";
    }
}
