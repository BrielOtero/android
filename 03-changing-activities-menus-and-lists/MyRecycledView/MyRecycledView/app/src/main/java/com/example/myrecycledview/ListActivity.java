package com.example.myrecycledview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ArrayList<Pelicula> peliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Datos d = Datos.getInstance();
        peliculas = d.getPelis("pelis");

        RecyclerView rv = (RecyclerView) findViewById(R.id.listRV);
        Adaptador adap = new Adaptador(peliculas, 1, this);
        rv.setAdapter(adap);
        StaggeredGridLayoutManager stg = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rv.setLayoutManager(stg);

        ImageView imgFav = (ImageView) findViewById(R.id.imgFav);


    }
}