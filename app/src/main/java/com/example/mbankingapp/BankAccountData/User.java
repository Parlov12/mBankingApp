package com.example.mbankingapp.BankAccountData;

import java.util.ArrayList;
import java.util.List;

public class User extends Account{
    String userId = "";
    List<Account> accounts = new ArrayList<>();

    public User() {

    }

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
