package com.example.mbankingapp.BankAccountData;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

// class used to load data from JSONObject after request
public class LoadBankAccountData {

    // pom variables
    int i = 0;
    int j = 0;

    public LoadBankAccountData() {
    }

    // fun that returns User object containing all data(user id, accounts, all transactions)
    public User getLoadBankAccountData(JSONObject jsonObject) {

        User user;

        try {
            // LOADING DATA FROM JSON OBJECT
            // user id
            user =  new User(jsonObject.getString("user_id"));
            // all user's accounts
            JSONArray racuni = jsonObject.getJSONArray("acounts");


            // adding all accounts to user.accounts list
            for(i = 0; i < racuni.length(); i++) {
                Account account = new Account();
                JSONObject racun = racuni.getJSONObject(i);

                account.setAmount(racun.getString("amount").toString());
                account.setId(racun.getString("id").toString());
                account.setIBAN(racun.getString("IBAN").toString());
                account.setCurrency(racun.getString("currency").toString());

                user.addAccount(account);

                JSONArray transakcije = racun.getJSONArray("transactions");

                for(j = 0; j < transakcije.length(); j++) {

                    Transaction transaction = new Transaction();

                    transaction.setAmount(transakcije.getJSONObject(j).getString("amount"));
                    transaction.setId(transakcije.getJSONObject(j).getString("id"));
                    transaction.setDate(transakcije.getJSONObject(j).getString("date"));
                    transaction.setDescription(transakcije.getJSONObject(j).getString("description"));

                    if(transakcije.getJSONObject(j).has("type")) {
                        transaction.setType(transakcije.getJSONObject(j).getString("type"));
                    };


                    account.transactions.add(transaction);
                }
                // transactions.add(racuni.getJSONArray(4));
            }

            return user;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

}
