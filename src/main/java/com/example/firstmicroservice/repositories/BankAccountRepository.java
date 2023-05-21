package com.example.firstmicroservice.repositories;

import com.example.firstmicroservice.entities.BankAccount;
import com.example.firstmicroservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepository  extends JpaRepository<BankAccount,String> {

  @RestResource(path = "/byType")
  List<BankAccount> findByType(@Param("t") AccountType type);

    BankAccount updateAccount(String id, BankAccount bankAccount);
}
