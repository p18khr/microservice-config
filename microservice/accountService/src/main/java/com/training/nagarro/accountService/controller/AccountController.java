package com.training.nagarro.accountService.controller;

import com.training.nagarro.accountService.models.Account;
import com.training.nagarro.accountService.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService service;


    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        Account acc = service.saveAccount(account);
        return  ResponseEntity.status(HttpStatus.CREATED).body(acc);
    }

    @PostMapping("/withdraw")
    public void withdrawAccount(@RequestBody Account account){
        service.withdraw(account.getAccount_no(), account.getAccount_balance());
//        return  ResponseEntity.ok(account);
    }

    @PostMapping("/deposit")
    public void depositAccount(@RequestBody Account account){
        service.deposit(account.getAccount_no(), account.getAccount_balance());
//        return  ResponseEntity.ok(account);
    }

    @GetMapping("/{account_no}")
    public Account getAcc(@PathVariable String account_no){
        Account acc = service.getAccount(account_no);

        return acc;
    }

    @GetMapping("/cust/{id}")
    public List<Account> getAccById(@PathVariable String id){
        List<Account> acc = service.getAccountById(id);
        return acc;
    }

    @DeleteMapping("/{account_no}")
    public void del(@PathVariable String account_no){

        service.deleteAccount(account_no);
    }

}
