package com.example.mbankingapp.DataManagment;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mbankingapp.MySingleton;

import org.json.JSONObject;


// used to remember data after user finish registration
public class BankAccountDataManager extends SharedPreferencesDataManager{

    // user data
    public String name = "";
    public String surname = "";
    public String pin = "";
    public int pinLength = 0;

    public BankAccountDataManager(Context context) {
        super(context);

    }


    // method used to store name and surname in SharedPreferences file
    public void storeCredentials(String ime, String prezime) {
        this.writeNewValue("NAME", ime);
        this.name = ime;
        this.writeNewValue("SURNAME", prezime);
        this.surname = prezime;
    }

    // store pin to SharedPreference file
    public void storePin(String pass) {
        this.writeNewValue("PIN", pass);
        this.pin = pass;
        this.pinLength = pass.length();
    }


    // GETTERS AND SETTERS
    public void setName(String name) {
        this.writeNewValue("NAME", name);
        this.name = name;
    }

    public void setSurname(String surname) {
        this.writeNewValue("SURNAME", surname);
        this.surname = surname;
    }

    public void setPin(String pin) {
        this.writeNewValue("PIN", pin);
        this.pin = pin;
    }

    public void setPinLength(int pinLength) {
        this.writeNewValue("PIN_LENGTH", pinLength);
        this.pinLength = pinLength;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPin() {
        return pin;
    }

    public int getPinLength() {
        return pinLength;
    }


}
