package com.example.firstmicroservice.service;

import com.example.firstmicroservice.DTO.BankAccountRequestDTO;
import com.example.firstmicroservice.DTO.BankAccountResponseDTO;
import com.example.firstmicroservice.entities.BankAccount;
import com.example.firstmicroservice.mappers.AccountMapper;
import com.example.firstmicroservice.repositories.BankAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service @Transactional
public class AccountServiceImpl implements AccountService {

@Autowired

    private BankAccountRepository bankAccountRepository;
@Autowired
    private AccountMapper accountMapper;
    @Override


    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {

        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBlance())
                .type(bankAccountDTO.getType())
                .build();
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
   BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponseDTO;
    }
}
