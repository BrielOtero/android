package com.example.a05_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();

        TextView txt1 = findViewById(R.id.textView);
        RatingBar rtb = findViewById(R.id.ratingBar2);

        txt1.setText(intent.getStringExtra("edittext"));
        rtb.setRating(intent.getFloatExtra("stars",0));

    }
}