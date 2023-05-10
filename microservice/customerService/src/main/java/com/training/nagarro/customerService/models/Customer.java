package com.training.nagarro.customerService.models;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name= "customer")
public class Customer {

    @Id
    private String id;

    @Column(nullable = false,length = 20,name="first_name")
    private String first_name;

    @Column(nullable = false,length = 20,name="last_name")
    private String last_name;

    @Column(nullable = false,length = 10,name="contact_no")
    private String contact_no;

    @Column(nullable = false,length = 50)
    private String address;

    @Transient
    private List<Account> accounts = new ArrayList<>();

}
