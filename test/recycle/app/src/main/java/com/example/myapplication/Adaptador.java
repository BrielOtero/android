package com.example.myapplication;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.Vh> {
    ArrayList<Pelicula> peliculas;
    int pos = RecyclerView.NO_POSITION;
    Context context;

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        if (pos == this.pos) {
            this.pos = RecyclerView.NO_POSITION;
            notifyItemChanged(pos);
        } else {
            if (this.pos > RecyclerView.NO_POSITION) {
                notifyItemChanged(pos);
            }

            this.pos = pos;
            notifyItemChanged(pos);
            Toast.makeText(context, getPos() + "", Toast.LENGTH_LONG).show();
        }

        this.pos = pos;
    }


    public Adaptador(ArrayList<Pelicula> peliculas, Context context) {
        this.peliculas = peliculas;
        this.context = context;
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
        holder.cover.setImageResource(peliculas.get(position).getPortada());
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public class Vh extends RecyclerView.ViewHolder {
        ImageView cover;

        public Vh(@NonNull View itemView) {
            super(itemView);
            cover = itemView.findViewById(R.id.imgCover);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setPos(getAdapterPosition());
                }
            });
        }
    }
}
