package com.api.store.service;

import com.api.store.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerById(long id);
    Customer updateCustomer(Customer customer, long id);
    void deleteCustomer(long id);
}
