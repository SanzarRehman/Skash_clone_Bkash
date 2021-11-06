package com.example.sanzar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class login extends AppCompatActivity {
    Button BT;
    RequestQueue requestQueue;
    private Calendar AppController;
    public TextView s;
    EditText ageEditText,pinn;
   public String pinnn;
   int b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       login.this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        setContentView(R.layout.activity_login);

        s= (TextView) findViewById(R.id.textView4);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ageEditText = (EditText) findViewById(R.id.editTextTextPersonName2);
                pinn = (EditText) findViewById(R.id.editTextNumberPassword);
                String e = pinn.getText().toString();


                sendGetRequest();

                if(e.equals(pinnn))
                {
                    s.setText("Success");

                    Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
                    intent.putExtra("balance", b);
                    startActivity(intent);
                    finish();

                }
                else
                {
                    s.setText("Wrong password");

                }

            }




                });

            }


            public void sendPostRequest(){



            }

    private void sendGetRequest() {
        RequestQueue Queue =Volley.newRequestQueue(login.this);

        String p = ageEditText.getText().toString();
    String url ="https://sanzar.herokuapp.com/customers/email/"+p;

    StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onResponse(String response) {

           s.setText("data"+response);
            JSONObject jObject = null;
            try {
                jObject = new JSONObject(response);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                String pin = jObject .getString("pin");


                s.setText(pin);
               pinnn= pin;

            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                int balance = jObject .getInt("balance");


                b=balance;


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            s.setText("data response failed");

        }
    });
    Queue.add((stringRequest));

    }

}



