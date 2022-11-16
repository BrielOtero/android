package com.example.a05_exercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Activity_secondary extends AppCompatActivity {
    RecyclerView recyclerViewListado;
    AdapterListado adapterListado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        adapterListado = new AdapterListado();
        GridLayoutManager grid= new GridLayoutManager(this,1, LinearLayoutManager.VERTICAL,false);
        findViewById(R.id.rvListado);
        recyclerViewListado= findViewById(R.id.rvListado);

    }
}