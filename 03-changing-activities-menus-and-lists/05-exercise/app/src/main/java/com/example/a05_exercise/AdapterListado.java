package com.example.a05_exercise;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterListado extends RecyclerView.Adapter<AdapterListado.ListadoVh> {


    @NonNull
    @Override
    public ListadoVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ListadoVh holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ListadoVh extends  RecyclerView.ViewHolder{

        public ListadoVh(@NonNull View itemView) {
            super(itemView);
        }
    }
}
