package com.example.a01_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOrientation = findViewById(R.id.btnOrientation);


        btnOrientation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    Toast.makeText(getApplicationContext(), "PORTRAIT", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "HORIZONTAL", Toast.LENGTH_LONG).show();

                }
            }
        });


    }
}