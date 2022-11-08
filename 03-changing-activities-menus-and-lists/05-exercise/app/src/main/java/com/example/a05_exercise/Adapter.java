package com.example.a05_exercise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Vh> {
    ArrayList<Pelicula> peliculas;

    public Adapter(ArrayList<Pelicula> peliculas){
        this.peliculas=peliculas;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda, parent, false);
        Vh vh = new Vh(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Vh holder, int position) {
        holder.tvTitle.setText(peliculas.get(position).titulo);
        holder.tvDirector.setText(peliculas.get(position).director);
        holder.imgCover.setImageResource(peliculas.get(position).portada);
        holder.imgAge.setImageResource(peliculas.get(position).clasi);
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public class Vh extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvDirector;
        public ImageView imgCover;
        public ImageView imgAge;


        public Vh(@NonNull View itemView) {
            super(itemView);

            this.tvTitle = itemView.findViewById(R.id.tvTitle);
            this.tvDirector = itemView.findViewById(R.id.tvDirector);
            this.imgCover = itemView.findViewById(R.id.imgCover);
            this.imgAge = itemView.findViewById(R.id.imgAge);
        }
    }


//ArrayList<Pelicula> peliculas;
//int pos

}
