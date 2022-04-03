package com.example.mbankingapp.BankAccountData;

public class Transaction {
    String id = "";
    String date = "";
    String description = "";
    String amount = "";
    String type = "";


    public Transaction(String id , String date , String description, String amount, String type){
        this.id = id;
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void updateTransaction(String id, String date, String description, String amount, String type) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.type = type.toString();
    }

    public void updateTransaction(String id, String date, String description, String amount) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.type = type.toString();
    }
}
