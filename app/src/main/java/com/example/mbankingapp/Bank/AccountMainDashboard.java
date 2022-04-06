package com.example.mbankingapp.Bank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mbankingapp.Adapter.CustomAdapter;
import com.example.mbankingapp.ApiRequest.BankAccountApiRequest;
import com.example.mbankingapp.BankAccountData.LoadBankAccountData;
import com.example.mbankingapp.BankAccountData.User;
import com.example.mbankingapp.DataManagment.SharedPreferencesDataManager;
import com.example.mbankingapp.Interface.BankAccountCallback;
import com.example.mbankingapp.R;

import org.json.JSONObject;

public class AccountMainDashboard extends AppCompatActivity {

    User user;

    TextView iban1;
    TextView iban2;
    TextView iban3;
    TextView balance1;
    TextView balance2;
    TextView balance3;
    LinearLayout racun1;
    LinearLayout racun2;
    LinearLayout racun3;

    SharedPreferencesDataManager sharedPreferencesDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_main_dashboard);

        View layout = findViewById(R.id.included_layout);

        iban1 = (TextView) layout.findViewById(R.id.iban1);
        iban2 = (TextView) layout.findViewById(R.id.iban2);
        iban3 = (TextView) layout.findViewById(R.id.iban3);
        balance1 = (TextView) layout.findViewById(R.id.balance1);
        balance2 = (TextView) layout.findViewById(R.id.balance2);
        balance3 = (TextView) layout.findViewById(R.id.balance3);
        racun1 = (LinearLayout) layout.findViewById(R.id.linear_racun1);
        racun2 = (LinearLayout) layout.findViewById(R.id.linear_racun2);
        racun3 = (LinearLayout) layout.findViewById(R.id.linear_racun3);

        sharedPreferencesDataManager = new SharedPreferencesDataManager(this);

        Intent showTransaction = new Intent(this, BankTransactions.class);



        BankAccountApiRequest bankAccountApiRequest = new BankAccountApiRequest(this);

        racun1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferencesDataManager.writeNewValue("NUM_OF_ACCOUNT", 0);
                startActivity(showTransaction);
            }
        });

        racun2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferencesDataManager.writeNewValue("NUM_OF_ACCOUNT", 1);
                startActivity(showTransaction);
            }
        });

        racun3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferencesDataManager.writeNewValue("NUM_OF_ACCOUNT", 2);
                startActivity(showTransaction);
            }
        });

        bankAccountApiRequest.getBankAccountData(new BankAccountCallback() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                user = new LoadBankAccountData().getLoadBankAccountData(jsonObject);
                Log.d("TAG", user.toString());
                Log.d("TAG", "OBRADIO PODATKE");
                String msg = "";

                iban1.setText(user.accounts.get(0).getIBAN());
                iban2.setText(user.accounts.get(1).getIBAN());
                iban3.setText(user.accounts.get(2).getIBAN());

                msg = user.accounts.get(0).getAmount() + " " + user.accounts.get(0).getCurrency();
                balance1.setText(msg);
                msg = user.accounts.get(1).getAmount() + " " + user.accounts.get(1).getCurrency();
                balance2.setText(msg);
                msg = user.accounts.get(2).getAmount() + " " + user.accounts.get(2).getCurrency();
                balance3.setText(msg);

            }
        });

    }
}