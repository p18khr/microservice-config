package com.training.nagarro.customerService.services;

import com.training.nagarro.customerService.models.Customer;

import java.util.List;

public interface CustomerService {

    // add new customer
    Customer saveCustomer(Customer customer);

    // get all customers
    List<Customer> getAllCustomers();

    // get one customer
    Customer getCustomer(String id);

    // update customer
    Customer updateCustomer(String id,Customer customer);

    // delete a customer
    void deleteCustomer(String id);
}
