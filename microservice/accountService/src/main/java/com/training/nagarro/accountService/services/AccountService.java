package com.training.nagarro.accountService.services;

import com.training.nagarro.accountService.AccountServiceApplication;
import com.training.nagarro.accountService.models.Account;

import java.util.List;

public interface AccountService {

    Account saveAccount(Account account);

    void deposit(String account_no,double amount);

    void withdraw(String account_no,double amount);

    Account getAccount(String id);

    void deleteAccount (String id);

    List<Account> getAccountById(String id);
}
