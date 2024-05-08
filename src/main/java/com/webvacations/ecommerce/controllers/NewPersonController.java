package com.webvacations.ecommerce.controllers;

import com.webvacations.ecommerce.dao.CustomerRepository;
import com.webvacations.ecommerce.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Maps to the customer
@RequestMapping("api/customers")
@CrossOrigin
@RestController
// Controller to add a new customer to the database
public class NewPersonController {
    private CustomerRepository customerRepository;
    @Autowired
    public NewPersonController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    // Save customer to database
    @PostMapping("/addcustomer")
    public void AddCustomer(@RequestBody Customer newPerson) {
        customerRepository.save(newPerson);
    }
}

