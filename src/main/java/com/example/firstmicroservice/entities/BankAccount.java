package com.example.firstmicroservice.entities;

import com.example.firstmicroservice.enums.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@lombok.Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
@Id
    private String id;

    private Date createdAt;
    private  Double balance;
    private  String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
}
