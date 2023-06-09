package com.example.firstmicroservice.mappers;


import com.example.firstmicroservice.DTO.BankAccountResponseDTO;
import com.example.firstmicroservice.entities.BankAccount;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.beans.Beans;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();

        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);

return bankAccountResponseDTO;
    }
}
