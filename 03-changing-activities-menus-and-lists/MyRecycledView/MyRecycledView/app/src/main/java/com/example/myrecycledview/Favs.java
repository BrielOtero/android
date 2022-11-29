package com.example.myrecycledview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Favs extends AppCompatActivity {
    ListView lv;
    ArrayList<Pelicula> peliculas;
    ArrayAdapter<Pelicula> adapter;
    ArrayList<String> nombrePelis = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favs);
        lv = findViewById(R.id.lv);
        Datos d = Datos.getInstance();
        peliculas = d.getPelis("pelis");
        for (int i = 0; i < peliculas.size(); i++) {
            nombrePelis.add(peliculas.get(i).getTitulo());
        }
        lv.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, nombrePelis);
        lv.setAdapter(adapter);
        for (int i = 0; i < peliculas.size(); i++) {
            lv.setItemChecked(i, peliculas.get(i).getFavorita());
        }
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                peliculas.get(position).setFavorita(lv.isItemChecked(position));
            }
        });
    }
}