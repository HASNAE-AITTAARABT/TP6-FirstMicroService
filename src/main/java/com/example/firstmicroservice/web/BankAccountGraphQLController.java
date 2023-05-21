package com.example.firstmicroservice.web;


import com.example.firstmicroservice.DTO.BankAccountRequestDTO;
import com.example.firstmicroservice.DTO.BankAccountResponseDTO;
import com.example.firstmicroservice.entities.BankAccount;
import com.example.firstmicroservice.repositories.BankAccountRepository;
import com.example.firstmicroservice.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
@Autowired
    private AccountService accountService;
    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Acount %s not found",id)));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);

    }

    @MutationMapping
    public BankAccount updateccount(@Argument String id,@Argument BankAccount bankAccount){

        return bankAccountRepository. updateAccount(id,bankAccount)
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
       bankAccountRepository.deleteById(id);
        return true;
    }


}
@Data @NoArgsConstructor @AllArgsConstructor
class BankAccountDTO{
    private Double balance;
 private String type;
 private String currency;

}