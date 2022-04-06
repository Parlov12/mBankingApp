package com.example.mbankingapp.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mbankingapp.Bank.AccountMainDashboard;
import com.example.mbankingapp.DataManagment.BankAccountDataManager;
import com.example.mbankingapp.DataManagment.SharedPreferencesDataManager;
import com.example.mbankingapp.R;
import com.example.mbankingapp.Register.ConfirmPinActivity;

public class LoginActivity extends AppCompatActivity {

    Intent accountMainDashBoardActivity;

    Button enterPinButton;

    EditText pinInput;

    Boolean enterButtonState = false;

    BankAccountDataManager bankAccountDataManager;

    SharedPreferencesDataManager sharedPreferencesDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferencesDataManager = new SharedPreferencesDataManager(this);

        // button that takes you to ConfirmPinActivity
        enterPinButton = (Button) findViewById(R.id.enterPinButton);

        // ConfirmPinActivity Intent
        accountMainDashBoardActivity = new Intent(this, AccountMainDashboard.class);

        // pin input button
        pinInput = (EditText) findViewById(R.id.pinInput);

        // bank account data
        bankAccountDataManager = new BankAccountDataManager(this);

        enterPinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pinInput.length() >= 4) {
                    if(pinInput.getText().toString().equals(sharedPreferencesDataManager.getValue("pin"))) {
                        startActivity(accountMainDashBoardActivity);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Pin incorrect or account not made!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}