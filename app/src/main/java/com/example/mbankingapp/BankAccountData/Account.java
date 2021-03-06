package com.example.mbankingapp.BankAccountData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


// class that contains all bank account data and transactions stored in the list transactions
public class Account {
    String id = "";
    String IBAN = "";
    String amount = "";
    String currency = "";
    public List<Transaction> transactions = new ArrayList<>();
    int counter = 0;


    public Account(String id, String iban, String amount, String currency) {
        this.id = id;
        this.IBAN = iban;
        this.amount = amount;
        this.currency = currency;
    }

    public Account() {

    }

    // GETTERS AND SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void updateTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void updateAccount(String id, String iban, String amount, String currency) {
        this.id = id;
        this.IBAN = iban;
        this.amount = amount;
        this.currency = currency;
    }



}
