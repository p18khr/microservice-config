package com.training.nagarro.customerService.dao;

import com.training.nagarro.customerService.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer,String> {

    @Modifying
    @Query(value="update Customer u set u.address = :address, u.contact_no = :contact_no, u.first_name = :first_name, u.last_name = :last_name where u.id = :id ")
    void updateById(@Param(value="address")String add,@Param(value="contact_no")String contact,@Param(value="first_name")String first,@Param(value="last_name")String last,@Param(value="id")String id);
}
