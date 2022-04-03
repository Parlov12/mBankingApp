package com.example.mbankingapp.BankAccountData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LoadBankAccountData {

    // user contains all data of one user
    User user;
    int numberOfAccounts = 0;
    // list of JSONArray-s
    // Each JSONArray in list represents transactions of one account
    List<JSONArray> transactions = new ArrayList<>();

    // pom variables
    int i = 0;
    int j = 0;
    Account emptyAccount = new Account("0", "0", "0", "0");
    Transaction emptyTransaction = new Transaction("0", "0","0","0", "");

    public LoadBankAccountData(JSONObject jsonObject) {
        try {
            // LOADING DATA FROM JSONObject TO LoadBankAccountData
            user.id = jsonObject.getString("id");
            JSONArray racuni = jsonObject.getJSONArray("acounts");
            for(i = 0; i < racuni.length(); i++) {
                this.emptyAccount.updateAccount(
                        racuni.getJSONObject(i).getString("id").toString(),
                        racuni.getJSONObject(i).getString("IBAN").toString(),
                        racuni.getJSONObject(i).getString("amount").toString(),
                        racuni.getJSONObject(i).getString("currency").toString());

                user.addAccount(this.emptyAccount);

                transactions.add(racuni.getJSONArray(4));

                this.numberOfAccounts += 1;
            }

            for(i = 0; i < transactions.size(); i++) {
                for(j = 0; j < transactions.get(j).size())
                emptyTransaction.updateTransaction(transactions.get(i).getJSONObject());
                user.accounts.get(i).transactions.
            }




        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
