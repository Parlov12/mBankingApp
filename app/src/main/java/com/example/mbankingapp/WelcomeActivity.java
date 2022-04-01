package com.example.mbankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mbankingapp.Register.RegisterActivityCredentials;

public class WelcomeActivity extends AppCompatActivity {

    Intent startRegistrationProcess;

    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        startRegistrationProcess = new Intent(this, RegisterActivityCredentials.class);
        registerBtn = (Button) findViewById(R.id.registerButton);


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(startRegistrationProcess);
            }
        });



    }
}