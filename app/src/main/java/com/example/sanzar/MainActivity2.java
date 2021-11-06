package com.example.sanzar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        ;

        final Button button = findViewById(R.id.button5);
        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("balance", 0);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                button.setBackground(getDrawable(R.drawable.b6));
                button.setTextColor(getResources().getColor(R.color.black));
                button.setText("Balance=1000tk");
                Toast.makeText(getApplicationContext(),intValue,Toast.LENGTH_SHORT).show();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button.setText("Check Balance");
                        button.setTextColor(getResources().getColor(R.color.white));
                        button.setBackground(getDrawable(R.drawable.b5));
                    }
                }, 4000);

            }
        });

    }


}