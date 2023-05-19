package com.example.firstmicroservice.web;

import com.example.firstmicroservice.DTO.BankAccountRequestDTO;
import com.example.firstmicroservice.DTO.BankAccountResponseDTO;
import com.example.firstmicroservice.entities.BankAccount;
import com.example.firstmicroservice.mappers.AccountMapper;
import com.example.firstmicroservice.repositories.BankAccountRepository;
import com.example.firstmicroservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
private AccountService accountService;
private AccountMapper accountMapper;

    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
    }

    @GetMapping("/bankAccount")
    public List<BankAccount> bankAccounts (){
        return  bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccount/{id}")
    public BankAccount bankAccounts (@PathVariable String id){
        return  bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException( String.format("Account %s not found",id) ));
    }
@PostMapping("/bankAccount")
public BankAccountResponseDTO save( @RequestBody BankAccountRequestDTO requestDTO){

return accountService.addAccount(requestDTO);
}
    @PutMapping("/bankAccount/{id}")
    public  BankAccount update( String id ,@RequestBody BankAccount bankAccount){
        BankAccount account =bankAccountRepository.findById(id).orElseThrow();
if (bankAccount.getBalance()!=null)account.setBalance(bankAccount.getBalance());
if (bankAccount.getCreatedAt()!=null)account.setCreatedAt(new Date());
if (bankAccount.getType()!=null)account.setType(bankAccount.getType());
if (bankAccount.getCurrency()!=null)account.setCurrency(bankAccount.getCurrency());


        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccount/{id}")
    public  void   deleteAccount(@PathVariable String id){
         bankAccountRepository.deleteById(id);
    }

}






