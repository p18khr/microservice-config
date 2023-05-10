package com.training.nagarro.accountService.dao;

import com.training.nagarro.accountService.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,String> {

    @Modifying
    @Query(value="update Account u set u.account_balance = u.account_balance + :amount where u.account_no = :account_no ")
    void add(@Param(value="account_no")String account_no,@Param(value="amount") double amount);

    @Modifying
    @Query(value="update Account u set u.account_balance = u.account_balance - :amount where u.account_no = :account_no and u.account_balance >= :amount  ")
    void sub(@Param(value="account_no")String account_no,@Param(value="amount") double amount);

    @Query(value="select * from Account u where u.customer_id = :id",nativeQuery = true)
    List<Account> findByCustId(@Param(value = "id") String id);
}
