package com.example.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.Vh> {
    ArrayList<Personaje> personajes;
    int pos = RecyclerView.NO_POSITION;

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        if (getPos() == pos) {
            personajes.remove(pos);
            notifyItemRemoved(pos);
        } else {

            if (getPos() > RecyclerView.NO_POSITION) {
                notifyItemChanged(getPos());
            }

            notifyItemChanged(pos);
            setPos(pos);
        }

    }

    public Adaptador(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
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
        holder.tvNombre.setText(personajes.get(position).getNombre());
        holder.tvEdad.setText(String.valueOf(personajes.get(position).getEdad()));
        holder.imageView.setImageResource(personajes.get(position).getImagen());

        if (getPos() == position) {
            holder.itemView.setBackgroundResource(R.color.selected);
        } else {
            holder.itemView.setBackgroundResource(R.color.fondo);
        }
    }

    @Override
    public int getItemCount() {
        return personajes.size();
    }

    public class Vh extends RecyclerView.ViewHolder {
        public TextView tvNombre;
        public TextView tvEdad;
        public ImageView imageView;

        public Vh(@NonNull View itemView) {
            super(itemView);

            this.tvNombre = itemView.findViewById(R.id.tvNombre);
            this.tvEdad = itemView.findViewById(R.id.tvEdad);
            this.imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int numCelda = getAdapterPosition();
                    setPos(numCelda);
                }
            });
        }
    }
}
