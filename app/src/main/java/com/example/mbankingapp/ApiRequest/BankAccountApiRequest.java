package com.example.mbankingapp.ApiRequest;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.mbankingapp.BankAccountData.LoadBankAccountData;
import com.example.mbankingapp.BankAccountData.User;
import com.example.mbankingapp.Interface.BankAccountCallback;
import com.example.mbankingapp.MySingleton;
import org.json.JSONObject;


// class used to do http request and retrieve JSONObject
public class BankAccountApiRequest {

    public Context context;

    // constructor
    public BankAccountApiRequest(Context ctx) {
        this.context = ctx;
    }

    // method getJSONObject that retrieves JSONObject + callback
    public void getBankAccountData (final BankAccountCallback callBack, RecyclerView recyclerView) {

        // url to get JSONObject containing user bank account data
        String url = "https://mportal.asseco-see.hr/builds/ISBD_public/Zadatak_1.json";

        // JSON object request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        if(callBack != null) {
                            callBack.onSuccess(response);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Couldn't get JSONObject! Check your internet connection!", Toast.LENGTH_SHORT).show();
                    }
                });

        // adding JSON object request to queue
        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

}
