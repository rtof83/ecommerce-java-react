package com.api.store.controller;

import com.api.store.model.Customer;
import com.api.store.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        super();
        this.customerService = customerService;
    }

    // build create customer REST API
    @PostMapping()
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }

    // build get all customers REST API
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
