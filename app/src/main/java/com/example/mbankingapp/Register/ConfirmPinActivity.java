package com.example.mbankingapp.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mbankingapp.Bank.BankDashboardActivity;
import com.example.mbankingapp.R;

public class ConfirmPinActivity extends AppCompatActivity {

    Button confirmConfirmBtn;
    Intent mainBankDashboardActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_pin);

        // button that confirms pin and takes you to BankDashBoardActivity
        confirmConfirmBtn = (Button) findViewById(R.id.confirmConfirmButton);

        // BankDashboardActivity
        mainBankDashboardActivity = new Intent(this, BankDashboardActivity.class);

        confirmConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(mainBankDashboardActivity);
            }
        });

    }
}