package com.example.myrecycledview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FullInfo extends AppCompatActivity {
    ArrayList<Pelicula> peliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filayout);
        ImageView imgPortada = (ImageView) findViewById(R.id.imgPortada);
        TextView tvInfo = (TextView) findViewById(R.id.tvInfo);
        Datos d = Datos.getInstance();
        peliculas = d.getPelis("pelis");
        Intent it = getIntent();
        int pos = it.getIntExtra("pos", RecyclerView.NO_POSITION);
        Pelicula p = peliculas.get(pos);
        ActionBar ab = getSupportActionBar();
        ab.setTitle(p.getTitulo());
        if (pos != RecyclerView.NO_POSITION){
            imgPortada.setImageResource(p.getPortada());
            tvInfo.setText(p.getSinopsis());
        }
        imgPortada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                watchYoutubeVideo(p.getIdYoutube());
            }
        });
    }

    public  void watchYoutubeVideo(String id){
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }
    }
}