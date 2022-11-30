package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public void onBackPressed() {
        String hola = "A";
        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
        intent.putExtra("a",hola);
        setResult(RESULT_OK,intent);
        finish();
        super.onBackPressed();
    }
}