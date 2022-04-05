package com.example.mbankingapp.BankAccountData;

import java.util.ArrayList;
import java.util.List;

// class that contains user id and list of accounts
public class User extends Account{
    String userId = "";
    public List<Account> accounts = new ArrayList<>();
    public int numberOfAccounts = 0;

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                '}';
    }

    public User(String id) {
        super();
        this.userId = id;

    }

    // GETTERS AND SETTERS
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account a) {
        accounts.add(a);
    }

    public void deleteAccount(int i) {
        accounts.remove(i);
    }


}
