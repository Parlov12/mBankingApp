package com.example.mbankingapp.Bank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.mbankingapp.Adapter.CustomAdapter;
import com.example.mbankingapp.BankAccountData.Account;
import com.example.mbankingapp.BankAccountData.LoadBankAccountData;
import com.example.mbankingapp.BankAccountData.Transaction;
import com.example.mbankingapp.BankAccountData.User;
import com.example.mbankingapp.ApiRequest.BankAccountApiRequest;
import com.example.mbankingapp.DataManagment.SharedPreferencesDataManager;
import com.example.mbankingapp.Interface.BankAccountCallback;
import com.example.mbankingapp.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class BankTransactions extends AppCompatActivity{

    // test Button
    Button requestBtn;

    // test TextView
    TextView responseTxt;

    // get JSONObject
    BankAccountApiRequest JSONObjectVar;

    // LoadBankAccountData
    LoadBankAccountData ldData;

    RecyclerView recyclerView;
    CustomAdapter adapter;

    // numberOfAccount - to know which transactions to load
    SharedPreferencesDataManager sharedPreferencesDataManager;
    int numOfAccount;

    String output = "";
    int numOfAccounts = 0;
    int j = 0;
    int i = 0;
    String msg = "";
    public User user;
    // Each JSONArray in list represents transactions of one account
    public List<Account> transactions = new ArrayList<>();
    Account emptyAccount = new Account("0", "0", "0", "0");
    Transaction emptyTransaction = new Transaction("0", "0","0","0", "");



    User pomUser = new User("ID");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_dashboard);

        sharedPreferencesDataManager = new SharedPreferencesDataManager(this);

        numOfAccount = sharedPreferencesDataManager.getIntValue("NUM_OF_ACCOUNT");


        responseTxt = (TextView) findViewById(R.id.responseText);

        // making TextView scrollable
        responseTxt.setMovementMethod(new ScrollingMovementMethod());

        recyclerView = (RecyclerView) findViewById(R.id.rw_adapter);

        BankAccountApiRequest bankAccountApiRequest = new BankAccountApiRequest(this);

       bankAccountApiRequest.getBankAccountData(new BankAccountCallback() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                user = new LoadBankAccountData().getLoadBankAccountData(jsonObject);
                Log.d("TAG", user.toString());
                Log.d("TAG", "OBRADIO PODATKE");

                adapter = new CustomAdapter(user, numOfAccount);

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(adapter);
            }
        });





       Log.d("TAG", "KRAJ PROGRAMA");





    }




}