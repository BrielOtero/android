package com.example.a05_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PeliculaActivity extends AppCompatActivity {
    public void watchYoutubeVideo(String id) {
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula);
        Intent intent = getIntent();
        TextView txtSinopsis = findViewById(R.id.txtSinopsisActPelicula);
        ImageButton imgButton = findViewById(R.id.imgActPelicula);

        txtSinopsis.setText(intent.getStringExtra("sinopsis"));
        imgButton.setImageResource(intent.getIntExtra("image", 0));
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                watchYoutubeVideo(intent.getStringExtra("idYoutube"));
            }
        });
    }
}