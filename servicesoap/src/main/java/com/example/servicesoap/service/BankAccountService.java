package com.example.servicesoap.service;


import com.example.servicesoap.model.BankAccount;
import com.example.servicesoap.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository repository;

    public BankAccount getAccountById(Long id) {
        return repository.findById(id).orElse(null);
    }
}

