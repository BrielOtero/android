package com.example.a05_exercise;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView txt1 = findViewById(R.id.textView);
        RatingBar rtb = findViewById(R.id.ratingBar2);
        Button btn = findViewById(R.id.button3);

        Intent intent = getIntent();
        txt1.setText(intent.getStringExtra("edittext"));
        rtb.setRating(intent.getFloatExtra("stars", 0));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnValue();
            }
        });
    }

    @Override
    public void onBackPressed() {
        returnValue();
        super.onBackPressed();
    }

    private void returnValue() {
        RatingBar rtb = findViewById(R.id.ratingBar2);
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        intent.putExtra("stars", rtb.getRating());
        setResult(RESULT_OK,intent);
        finish();
    }
}