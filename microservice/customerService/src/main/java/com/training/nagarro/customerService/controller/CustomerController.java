package com.training.nagarro.customerService.controller;

import com.training.nagarro.customerService.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.training.nagarro.customerService.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;


    // create a customer
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer customer1 = service.saveCustomer(customer);
        return  ResponseEntity.status(HttpStatus.CREATED).body(customer1);
    }

    // get one Customer
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getOne(@PathVariable String id){
        Customer customer1 = service.getCustomer(id);
        return ResponseEntity.ok(customer1);
    }

    // get all customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAll(){
        List<Customer> list = service.getAllCustomers();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public String del(@PathVariable String id){
        service.deleteCustomer(id);
        return "deleted customer with id: "+id;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@RequestBody Customer customer, @PathVariable String id){
        service.updateCustomer(id,customer);
        return ResponseEntity.ok(customer);
    }


}
