package com.api.store.service;

import com.api.store.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomers();
}
