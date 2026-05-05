package com.banking.model;

import jakarta.persistence.*;
import lombok.Data;


@Table(name = "accounts")
@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account holder name")
    private String accountHolderName;
    @Column(name="balance")
    private double balance;

}
