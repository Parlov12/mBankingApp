package com.example.mbankingapp.DataManagment;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mbankingapp.MySingleton;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


// class used to do http request and retrieve JSONObject
public class JSONObjectData {

    public Context context;
    public JSONObject JSONObjectContent;

    // constructor
    public JSONObjectData(Context ctx) {
        this.context = ctx;
    }

    // method getJSONObject that retrieves JSONObject + callback
    public JSONObject getJSONObject (final VolleyCallBack callBack) {


        // url to get JSONObject containing user bank account data
        String url = "https://mportal.asseco-see.hr/builds/ISBD_public/Zadatak_1.json";

        // JSON object request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("JSONObject response", response.toString());
                        try {
                            JSONObjectContent = response;
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.d("RESPONSE_ERROR", "Response error!");
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
        return JSONObjectContent;
    }

    // defining a callback in the case code changes in the future
    public interface VolleyCallBack {
        void onSuccess();
    }

}
