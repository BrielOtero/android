package com.example.a04_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void pulseButton(View view) {
        TextView txtView = findViewById(R.id.textView);
        EditText editText = findViewById(R.id.editTextTextPersonName);

        String value = editText.getText().toString();
        txtView.setText(value);

        if (value.contains("a")) {
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        }

        txtView.setVisibility(View.VISIBLE);

    }
}