package com.example.a05_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {
    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView lstFavoritos;
    ArrayList<Pelicula> movies=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Intent intent = getIntent();

        lstFavoritos = findViewById(R.id.lstFavoritosActFav);
        lstFavoritos.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        movies = (ArrayList<Pelicula>) intent.getSerializableExtra("movies");

        for (int i = 0; i < movies.size(); i++) {
            list.add(movies.get(i).getTitulo());
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, list);
        lstFavoritos.setAdapter(adapter);


        for (int j = 0; j < movies.size(); j++) {
            lstFavoritos.setItemChecked(j, movies.get(j).getFavorita());
        }
        lstFavoritos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                movies.get(i).setFavorita(lstFavoritos.isItemChecked(i));
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intentBack = new Intent(FavoritosActivity.this, MainActivity.class);
        intentBack.putExtra("movies", movies);
        setResult(RESULT_OK, intentBack);
        finish();
        super.onBackPressed();
    }
}