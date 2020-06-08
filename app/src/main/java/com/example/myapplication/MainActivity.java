package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    private static final Object TAG ="MainActivity" ;
    EditText et_name, et_mail,et_method;
    Button bt_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name=findViewById(R.id.et_name);
        et_mail=findViewById(R.id.et_email);
        et_method=findViewById(R.id.et_method);

        bt_submit=findViewById(R.id.bt_submit);

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                makeJsonObjReq();

            }
        });

    }
    private void makeJsonObjReq()  {

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
               "https://stamforty.com/demo/employee.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       // progressDialog.dismiss();
                        Log.d("response", response.toString());
                        Toast.makeText(MainActivity.this, "" + response, Toast.LENGTH_SHORT).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       // progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("method", et_method.getText().toString());
                params.put("name",et_name.getText().toString());
                params.put("email", et_mail.getText().toString());
                return params;
            }

          /*  @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json; charset=UTF-8");
               // headers.put("Authorization", "token 0ee1248c5a84e8b1e36a8a15da48c0bb7580926c");
                return headers;
            }*/
        };
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(MainActivity.this,MyTasks.class);
        startActivity(intent);
        finish();
    }

       /* Map<String, String> postParam = new HashMap<String, String>();
        postParam.put("method", "addEmployee");
        postParam.put("name","krishna");
        postParam.put("email", "krishna@gmail.com");
        *//*postParam.put("name",et_name.getText().toString());
        postParam.put("email", et_mail.getText().toString());*//*

        //JSONObject parameters = new JSONObject(postParam);



        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, "https://stamforty.com/demo/employee.php", new JSONObject(postParam.toString()), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                        Log.d("response", response.toString());
                        Toast.makeText(MainActivity.this,""+response,Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error: " + error.getMessage());
                Toast.makeText(MainActivity.this,""+error,Toast.LENGTH_LONG).show();

            }
        }) {

            *//**
             * Passing some request headers
             * *//*
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }


        };

        Volley.newRequestQueue(this).add(jsonRequest);

    }*/
}