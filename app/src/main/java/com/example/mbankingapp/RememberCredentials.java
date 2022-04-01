package com.example.mbankingapp;

import android.content.Context;

import com.example.mbankingapp.DataManagment.UserDataManager;

// class used to get user's name, surname and pin
// and store them to SharedPreference file using DataManager
public class RememberCredentials extends UserDataManager {
    // data
    String name = "";
    String surname = "";
    private String pin = "";
    private int pinLength = 0;

    // constructors
    public RememberCredentials(Context context) {
        super(context);
    }

    // GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.writeNewValue("NAME", name);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        this.writeNewValue("SURNAME", surname);
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
        this.writeNewValue("PIN", pin);
        this.pinLength = pin.length();
    }

    public int getPinLength() {
        return pinLength;
    }

    public void setPinLength(int pinLength) {
        this.pinLength = pinLength;
    }
}
