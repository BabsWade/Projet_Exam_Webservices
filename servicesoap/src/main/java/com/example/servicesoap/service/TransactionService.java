package com.example.servicesoap.service;


import com.example.servicesoap.model.Transaction;
import com.example.servicesoap.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    public Page<Transaction> getTransactions(Long accountId, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return repository.findByAccountId(accountId, pageable);
    }
}

