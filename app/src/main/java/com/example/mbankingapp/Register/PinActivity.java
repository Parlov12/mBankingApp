package com.example.mbankingapp.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.toolbox.BasicNetwork;
import com.example.mbankingapp.DataManagment.BankAccountDataManager;
import com.example.mbankingapp.R;

public class PinActivity extends AppCompatActivity {

    Intent confirmPinActivity;

    Button enterPinButton;

    EditText pinInput;

    Boolean enterButtonState = false;

    BankAccountDataManager bankAccountDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);

        // button that takes you to ConfirmPinActivity
        enterPinButton = (Button) findViewById(R.id.enterPinButton);

        // ConfirmPinActivity Intent
        confirmPinActivity = new Intent(this, ConfirmPinActivity.class);

        // pin input button
        pinInput = (EditText) findViewById(R.id.pinInput);

        // bank account data
        bankAccountDataManager = new BankAccountDataManager(this);

        enterPinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pinInput.length() >= 4) {
                    bankAccountDataManager.storePin(pinInput.getText().toString());
                    startActivity(confirmPinActivity);
                }
            }
        });
    }
}