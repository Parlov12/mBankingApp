package com.example.mbankingapp.Bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mbankingapp.MySingleton;
import com.example.mbankingapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class BankDashboardActivity extends AppCompatActivity {

    Button requestBtn;

    TextView responseTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_dashboard);


        requestBtn = (Button) findViewById(R.id.request);

        responseTxt = (TextView) findViewById(R.id.responseText);
        // ...

        // making TextView scrollable
        responseTxt.setMovementMethod(new ScrollingMovementMethod());


        requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "https://mportal.asseco-see.hr/builds/ISBD_public/Zadatak_1.json";

                // JSON object request
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                String output = "";
                                int i = 0;
                                int j = 1;
                                int numOfAccounts = 0;

                                // get all data out of response
                                try {
                                    String userId = response.getString("user_id");
                                    JSONArray accounts = response.getJSONArray("acounts");

                                    // output to text view
                                    output += "User id: " + userId + '\n';
                                    numOfAccounts = accounts.length() + 1;
                                    output += "Number of accounts: " + numOfAccounts + '\n';
                                    for(i = 0; i < accounts.length(); i++) {
                                        j++;
                                        output += j + ". account: \n";
                                        output += accounts.getJSONObject(i).getString("IBAN").toString() + '\n';
                                    }



                                    responseTxt.setText(output);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Log.d("TAG", "JSONEcpetion: " + e.toString());
                                }



                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                responseTxt.setText("Something went wrong! Check your internet connection maybe!");
                            }
                        });

                // adding JSON object request to queue
                MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);


            }
        });





    }

}