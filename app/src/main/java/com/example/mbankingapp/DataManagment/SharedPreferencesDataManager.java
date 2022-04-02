package com.example.mbankingapp.DataManagment;

import android.content.Context;
import android.content.SharedPreferences;

// class used to write data to SharedPreference file and to store it permanently
public class SharedPreferencesDataManager {

    // SharedPreference
    SharedPreferences pref;
    // editor used to edit SharedPreference file
    SharedPreferences.Editor editor;

    // constructor
    public SharedPreferencesDataManager(Context context) {
        pref = context.getSharedPreferences("sharedPreferencesFile", Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    // write custom int value to SharedPreference file
    public void writeNewValue(String nameValue, int value) {
        editor.putInt(nameValue, value);
        editor.commit();
    }

    // write custom String value to SharedPreference file
    public void writeNewValue(String nameValue, String value) {
        editor.putString(nameValue, value);
        editor.commit();
    }


}
