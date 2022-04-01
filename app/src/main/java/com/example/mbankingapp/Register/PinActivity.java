package com.example.mbankingapp.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mbankingapp.R;

public class PinActivity extends AppCompatActivity {

    Intent confirmPinActivity;

    Button confirmPinBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);

        // button that takes you to ConfirmPinActivity
        confirmPinBtn = (Button) findViewById(R.id.confirmButton);

        // ConfirmPinActivity Intent
        confirmPinActivity = new Intent(this, ConfirmPinActivity.class);


        confirmPinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(confirmPinActivity);
            }
        });
    }
}