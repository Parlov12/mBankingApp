package com.example.mbankingapp.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mbankingapp.Bank.BankDashboardActivity;
import com.example.mbankingapp.DataManagment.BankAccountDataManager;
import com.example.mbankingapp.Interface.BankAccountCallback;
import com.example.mbankingapp.R;

public class ConfirmPinActivity extends AppCompatActivity {

    Button confirmConfirmBtn;
    EditText confirmPinInput;
    Intent mainBankDashboardActivity;
    BankAccountDataManager bankAccountDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_pin);

        // button that confirms pin and takes you to BankDashBoardActivity
        confirmConfirmBtn = (Button) findViewById(R.id.confirmConfirmButton);

        // BankDashboardActivity
        mainBankDashboardActivity = new Intent(this, BankDashboardActivity.class);

        // bank account data
        bankAccountDataManager = new BankAccountDataManager(this);

        // confirm pin input
        confirmPinInput = (EditText) findViewById(R.id.confirmPinInput);

        confirmConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(confirmPinInput.getText().toString().equals(bankAccountDataManager.getValue("PIN"))) {
                    startActivity(mainBankDashboardActivity);
                }
            }
        });

    }
}