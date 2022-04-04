package com.example.mbankingapp.Bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mbankingapp.BankAccountData.LoadBankAccountData;
import com.example.mbankingapp.Constants;
import com.example.mbankingapp.DataManagment.JSONObjectData;
import com.example.mbankingapp.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class BankDashboardActivity extends AppCompatActivity{

    // test Button
    Button requestBtn;

    // test TextView
    TextView responseTxt;

    // get JSONObject
    JSONObjectData JSONObjectVar;

    // LoadBankAccountData
    LoadBankAccountData ldData;


    String output = "";
    int numOfAccounts = 0;
    int j = 0;
    int i = 0;
    String msg = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_dashboard);


        requestBtn = (Button) findViewById(R.id.request);

        responseTxt = (TextView) findViewById(R.id.responseText);

        // making TextView scrollable
        responseTxt.setMovementMethod(new ScrollingMovementMethod());


        // making request and getting JSONObject
        JSONObjectVar  = new JSONObjectData(this);

        ldData = JSONObjectVar.getBankAccountData();

        msg += "User id:" + ldData.user.getUserId();

        responseTxt.setText(msg);



    }




}