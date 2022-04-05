package com.example.mbankingapp.Bank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.example.mbankingapp.Interface.BankAccountCallback;
import com.example.mbankingapp.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class BankDashboardActivity extends AppCompatActivity{

    // test Button
    Button requestBtn;

    // test TextView
    TextView responseTxt;

    // get JSONObject
    BankAccountApiRequest JSONObjectVar;

    // LoadBankAccountData
    LoadBankAccountData ldData;


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


    RecyclerView rw;
    User pomUser = new User("ID");
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_dashboard);


        requestBtn = (Button) findViewById(R.id.request);

        responseTxt = (TextView) findViewById(R.id.responseText);

        // making TextView scrollable
        responseTxt.setMovementMethod(new ScrollingMovementMethod());

        rw = (RecyclerView) findViewById(R.id.rw_adapter);

        BankAccountApiRequest bankAccountApiRequest = new BankAccountApiRequest(this);

       bankAccountApiRequest.getBankAccountData(new BankAccountCallback() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                user = new LoadBankAccountData().getLoadBankAccountData(jsonObject);
                Log.d("TAG", user.toString());
                Log.d("TAG", "OBRADIO PODATKE");

                adapter = new CustomAdapter(user, 0);

                rw.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rw.setAdapter(adapter);
            }
        });





       Log.d("TAG", "KRAJ PROGRAMA");





    }




}