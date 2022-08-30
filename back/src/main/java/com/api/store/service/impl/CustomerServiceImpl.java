package com.api.store.service.impl;

import com.api.store.exception.ResourceNotFoundException;
import com.api.store.model.Customer;
import com.api.store.repository.CustomerRepository;
import com.api.store.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(long id) {
        Optional<Customer> customer = customerRepository.findById(id);

//        if (customer.isPresent()) {
//            return customer.get();
//        } else {
//            throw new ResourceNotFoundException("Customer", "Id", id);
//        }

        return customerRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Customer", "Id", id));
    }

    @Override
    public Customer updateCustomer(Customer customer, long id) {

        // check if customer exist
        Customer existCustomer = customerRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Customer", "Id", id));

        existCustomer.setAddress(customer.getAddress());
        existCustomer.setName(customer.getName());
        existCustomer.setCpf(customer.getCpf());
        existCustomer.setEmail(customer.getEmail());
        existCustomer.setBirth(customer.getBirth());
        existCustomer.setPhone(customer.getPhone());
        existCustomer.setPassword(customer.getPassword());

        // save customer to DB
        customerRepository.save(existCustomer);
        return existCustomer;
    }

    @Override
    public void deleteCustomer(long id) {

        // check if customer exist
        Customer existCustomer = customerRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Customer", "Id", id));

        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> login(String email, String password) {
        return customerRepository.login(email, password);
    }
}
