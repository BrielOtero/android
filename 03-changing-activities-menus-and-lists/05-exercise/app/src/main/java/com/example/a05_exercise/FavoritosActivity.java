package com.example.a05_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Intent intent = getIntent();
        ListView lstFavoritos = findViewById(R.id.lstFavoritosActFav);
        ArrayList<Pelicula> movies = (ArrayList<Pelicula>) intent.getSerializableExtra("movies");
//        adapter= new ArrayAdapter<>(this,R.layout.)
//        for (int i = 0; i < movies.size(); i++) {
//
//            lstFavoritos.addall
//
//        }
    }
}