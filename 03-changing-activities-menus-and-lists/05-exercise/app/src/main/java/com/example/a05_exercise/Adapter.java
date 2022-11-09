package com.example.a05_exercise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Vh> {
    ArrayList<Pelicula> peliculas;
    int pos = RecyclerView.NO_POSITION;
    TextView txtValue;
    View.OnClickListener listener;
    int imgPreview;

    public int getImgPreview() {
        return imgPreview;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        if (getPos() == pos) {
            this.pos = RecyclerView.NO_POSITION;
            notifyItemChanged(this.pos);
        } else {

            if (this.pos > RecyclerView.NO_POSITION) {
                notifyItemChanged(this.pos);
            }
            this.pos = pos;
            notifyItemChanged(pos);
        }

    }

    public Adapter(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
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
        this.imgPreview = peliculas.get(position).portada;

        if (getPos() == position) {
            holder.tvColor.setVisibility(View.VISIBLE);
        } else {
            holder.tvColor.setVisibility(View.INVISIBLE);
        }



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
        public TextView tvColor;


        public Vh(@NonNull View itemView) {
            super(itemView);

            this.tvTitle = itemView.findViewById(R.id.tvTitle);
            this.tvDirector = itemView.findViewById(R.id.tvDirector);
            this.imgCover = itemView.findViewById(R.id.imgCoverPreview);
            this.imgAge = itemView.findViewById(R.id.imgAge);
            this.tvColor = itemView.findViewById(R.id.tvColor);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setPos(getAdapterPosition());
                    if (getPos() > RecyclerView.NO_POSITION) {
                        Toast.makeText(v.getContext(), getPos() + "", Toast.LENGTH_SHORT).show();
                        listener.onClick(v);
                    }
                }
            });
        }
    }

}
