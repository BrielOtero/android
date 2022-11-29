package com.example.myrecycledview;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.myVH> {
    ArrayList<Pelicula> peliculas;
    private View.OnClickListener listener;
    int selectedPos = RecyclerView.NO_POSITION;
    Datos d;
    Context ctx;
    int requestCode;

    public int getSelectedPos() {
        return selectedPos;
    }

    public void setSelectedPos(int selectedPos) {
        if (selectedPos == this.selectedPos){
            notifyItemChanged(selectedPos);
            this.selectedPos=RecyclerView.NO_POSITION;
        } else {
            if (this.selectedPos >=0 ) {
                notifyItemChanged(this.selectedPos);
            }
            this.selectedPos = selectedPos;
            notifyItemChanged(selectedPos);
        }
    }

    public Adaptador(ArrayList<Pelicula> peliculas){
        d = Datos.getInstance();
        this.peliculas = d.getPelis("pelis");
    }

    public Adaptador(ArrayList<Pelicula> peliculas, int requestCode, Context context){
        d = Datos.getInstance();
        this.peliculas = d.getPelis("pelis");
        this.ctx = context;
        this.requestCode = requestCode;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public myVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = R.layout.rvlayout;
        switch (requestCode) {
            case 1:
                layout = R.layout.listlayout;
                break;
        }
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new myVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myVH holder, int position) {
        holder.imgPelicula.setImageResource(peliculas.get(position).getPortada());
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        switch (requestCode){
            case 1:
                holder.imgEdades.setImageResource(peliculas.get(position).getClasi());
                holder.tvDirector.setText(peliculas.get(position).getDirector());
                holder.tvEstreno.setText(date.format(peliculas.get(position).getFecha()));
                holder.tvDur.setText(peliculas.get(position).getDuracion()+"");
                holder.tvSala.setText(peliculas.get(position).getSala());
                holder.imgFav.setVisibility(peliculas.get(position).getFavorita() ? View.VISIBLE : View.INVISIBLE);
                break;
            case 2:
                holder.tvInfo.setText(peliculas.get(position).sinopsis);
                break;
            default:
                holder.imgEdades.setImageResource(peliculas.get(position).getClasi());
                holder.tvDirector.setText(peliculas.get(position).getDirector());
                holder.tvTitulo.setText(peliculas.get(position).getTitulo());
                break;
            }

        if (selectedPos == position){
            Context ctx = holder.imgPelicula.getContext();
            Intent it = new Intent(ctx, FullInfo.class);
            it.putExtra("pos", getSelectedPos());
            ctx.startActivity(it);

        } else {
            holder.itemView.setBackgroundResource(androidx.cardview.R.color.cardview_light_background);
        }
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public class myVH extends RecyclerView.ViewHolder{
        private TextView tvTitulo;
        private TextView tvDirector;
        private TextView tvEstreno;
        private TextView tvDur;
        private TextView tvSala;
        private ImageView imgPelicula;
        private ImageView imgEdades;
        private TextView tvInfo;
        private ImageView imgFav;

        public myVH(@NonNull View itemView) {
            super(itemView);
            imgPelicula = itemView.findViewById(R.id.imgPortada);
            imgEdades = itemView.findViewById(R.id.imgEdades);
            tvTitulo=itemView.findViewById(R.id.tvTitulo);
            tvDirector=itemView.findViewById(R.id.tvDirector);
            tvEstreno = itemView.findViewById(R.id.tvEstreno);
            tvDur = itemView.findViewById(R.id.tvDur);
            tvSala = itemView.findViewById(R.id.tvSala);
            tvInfo = itemView.findViewById(R.id.tvInfo);
            imgFav = itemView.findViewById(R.id.imgFav);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    setSelectedPos(pos);
                    if (requestCode == 0){
                        listener.onClick(view);
                    }
                }
            });
        }
    }

}
