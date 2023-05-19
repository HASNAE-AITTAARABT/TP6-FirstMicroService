package com.example.firstmicroservice.service;

import com.example.firstmicroservice.DTO.BankAccountRequestDTO;
import com.example.firstmicroservice.DTO.BankAccountResponseDTO;

public interface AccountService {


    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

}