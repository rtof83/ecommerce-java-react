package com.api.store.controller;

import com.api.store.model.Customer;
import com.api.store.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        super();
        this.customerService = customerService;
    }

    // build create customer
    @PostMapping()
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        if (customerService.findByEmail(customer.getEmail()).isEmpty()) {
            return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);
        } else {
            return new ResponseEntity("email already exist", HttpStatus.BAD_REQUEST);
        }
    }

    // build get login
    @PostMapping("login")
    public ResponseEntity<List> loginCustomer(@RequestBody Customer customer) {
        return new ResponseEntity(customerService.login(customer.getEmail(), customer.getPassword()), HttpStatus.OK);
    }

    // build get all customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // build get customer by id
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long customerId) {
        return new ResponseEntity<Customer>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    // build get email
    @PostMapping("checkEmail")
    public ResponseEntity<List> findByEmail(@RequestBody Customer customer) {
        return new ResponseEntity(customerService.findByEmail(customer.getEmail()), HttpStatus.OK);
    }

    //build update customer
    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
        return new ResponseEntity<Customer>(customerService.updateCustomer(customer, id), HttpStatus.CREATED);
    }

    // build delete customer
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<String>("Customer deleted successfully", HttpStatus.NO_CONTENT);
    }
}
