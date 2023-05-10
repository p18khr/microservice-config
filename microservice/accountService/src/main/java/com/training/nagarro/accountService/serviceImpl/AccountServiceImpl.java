package com.training.nagarro.accountService.serviceImpl;

import com.training.nagarro.accountService.dao.AccountRepository;
import com.training.nagarro.accountService.exception.ResourceNotFoundException;
import com.training.nagarro.accountService.models.Account;
import com.training.nagarro.accountService.services.AccountService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository repo;

    @Override
    public Account saveAccount(Account account) {
        String acc = String.format("%040d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));;
        account.setAccount_no(acc);
        return repo.save(account);
    }

    @Override
    public void deposit(String account_no, double amount) {
            repo.add(account_no, amount);
    }

    @Override
    public void withdraw(String account_no, double amount) {
            repo.sub(account_no, amount);
    }

    @Override
    public Account getAccount(String account_no) {
        return repo.findById(account_no).orElseThrow(()-> new ResourceNotFoundException("given account_no is not found"));
    }

    @Override
    public void deleteAccount(String account_no) {
        repo.deleteById(account_no);
    }

    @Override
    public List<Account> getAccountById(String id) {
        return repo.findByCustId(id);
    }
}
