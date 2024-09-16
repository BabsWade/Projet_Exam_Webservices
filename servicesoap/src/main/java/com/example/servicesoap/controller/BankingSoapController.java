package com.example.servicesoap.controller;

import com.example.servicesoap.model.BankAccount;
import com.example.servicesoap.model.Transaction;
import com.example.servicesoap.service.BankAccountService;
import com.example.servicesoap.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

@Service
@WebService(serviceName = "BankingService")
public class BankingSoapController {
    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private TransactionService transactionService;

    @WebMethod
    public BankAccount getBalance(Long accountId) {
        return bankAccountService.getAccountById(accountId);
    }

    @WebMethod
    public Page<Transaction> getTransactions(Long accountId, int pageNumber, int pageSize) {
        return transactionService.getTransactions(accountId, pageNumber, pageSize);
    }

    @WebMethod
    public String transferFunds(Long creditor, Long debtor, BigDecimal amount, String currency) {
        // Implémentez la logique de virement ici
        return "Transfer completed";
    }
}
