package com.example.mbankingapp.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mbankingapp.DataManagment.BankAccountDataManager;
import com.example.mbankingapp.R;

public class RegisterActivityCredentials extends AppCompatActivity {

    // EditText elements
    EditText nameEdit;
    EditText surnameEdit;

    // Object used to manage user's data
    BankAccountDataManager userData;

    // just button
    Button continueBtn;

    // to get current context
    Context context;
    Intent startPinActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_credentials);

        // EditText elements for name and surname
        nameEdit = (EditText) findViewById(R.id.name);
        surnameEdit = (EditText) findViewById(R.id.surname);

        // Credentials manager
        userData = new BankAccountDataManager(this);

        // Continue button
        continueBtn = (Button) findViewById(R.id.continueButton);

        // get application context
        context = getApplicationContext();

        // registration intent
        startPinActivity = new Intent(context, PinActivity.class);


        // test credentials
        nameEdit.setText("Petar");
        surnameEdit.setText("Parlov");


        // continue button - click listener
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // check if name is empty
                if(nameEdit.getText().toString().equals("")){
                    Toast.makeText(context, "Name missing", Toast.LENGTH_SHORT).show();
                }
                // check if surname is empty
                else if(surnameEdit.getText().toString().equals("")){
                    Toast.makeText(context, "Surname missing", Toast.LENGTH_SHORT).show();                }
                else {
                    // Writes name and surname into SharedPreference file
                    userData.storeCredentials(nameEdit.getText().toString(), surnameEdit.getText().toString());

                    // continue registration process
                    startActivity(startPinActivity);

                }
            }
        });


    }
}