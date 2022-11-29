package com.example.a05_exercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondaryActivity extends AppCompatActivity {
    RecyclerView recyclerViewListado;
    AdapterListado adapterListado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        Intent intent = getIntent();
        ArrayList<Pelicula>movies= (ArrayList<Pelicula>)intent.getSerializableExtra("movies");
        adapterListado = new AdapterListado(this,movies);
        GridLayoutManager grid= new GridLayoutManager(this,1, LinearLayoutManager.VERTICAL,false);
        recyclerViewListado= findViewById(R.id.rvListado);
        recyclerViewListado.setLayoutManager(grid);
        recyclerViewListado.setAdapter(adapterListado);


    }
}