package com.training.nagarro.customerService.serviceImpl;

import com.training.nagarro.customerService.dao.CustomerRepository;
import com.training.nagarro.customerService.exception.ResourceNotFoundException;
import com.training.nagarro.customerService.models.Account;
import com.training.nagarro.customerService.models.Customer;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.nagarro.customerService.services.CustomerService;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repo;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);


    @Override
    public Customer saveCustomer(Customer customer) {

        // generate unique id and account number

        String id = String.format("%040d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
        Account account = new Account();
        account.setAccount_balance(0);
        account.setCustomer_id(id);
        restTemplate.postForObject("http://ACCOUNT-SERVICE/account",account,Account.class);
        customer.setId(id);
        return repo.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {

        List<Customer> list = repo.findAll();

        for(Customer c: list){
            List<Account> forObject = restTemplate.getForObject("http://ACCOUNT-SERVICE/account/cust/"+c.getId(), List.class);
            c.setAccounts(forObject);
        }

        return list;
    }

    @Override
    public Customer getCustomer(String id) {

        Customer customer =  repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user with given id is not found"));

        // fetch the account list of the customers in the bank using customer_id
        // sample url for api - http://localhost:8082/account/cust/scjakjhkjak

        List<Account> forObject = restTemplate.getForObject("http://ACCOUNT-SERVICE/account/cust/"+id, List.class);

        customer.setAccounts(forObject);
        return customer;
    }

    @Override
    public Customer updateCustomer(String id, Customer customer) {
        repo.updateById(customer.getAddress(), customer.getContact_no(), customer.getFirst_name(), customer.getLast_name(), id);
        return  customer;
    }

    @Override
    public void deleteCustomer(String id) {

        repo.deleteById(id);
    }
}
