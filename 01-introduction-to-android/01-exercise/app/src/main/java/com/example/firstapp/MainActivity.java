package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG,"método onCreate");

        Toast toast=Toast.makeText(getApplicationContext(), "Prueba de Toast", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER|Gravity.LEFT, 0, 10);
        toast.show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"método onStart");
    }

    @Override
                                                                 protected void onResume() {
        super.onResume();
        Log.i(TAG,"método onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"método onPause de tipo Error");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"método onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.w(TAG,"método onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"método onDestroy");
    }


}