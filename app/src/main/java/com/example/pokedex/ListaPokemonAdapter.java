package com.example.pokedex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pokedex.models.Pokemon;

import java.util.ArrayList;

public class ListaPokemonAdapter extends RecyclerView.Adapter<ListaPokemonAdapter.ViewHolder> {




    /*
    Aqui voy a programar a la lista que se mostrara en el
    item list
     */
   private ArrayList<Pokemon> dataset;
    private Context context;

    public ListaPokemonAdapter(Context context){

        this.context = context;
        dataset = new ArrayList<>();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Pokemon p = dataset.get(position);
        holder.txtNombre.setText(p.getName());

        // Esta es mi url de pokemon en la cual obtengo mis imagenes
        String pokemonImageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" +p.getNumber() + ".png";
        //utilizando la dependencia glide para decodificarlos
        Glide.with(context)
                .load(pokemonImageUrl)
                .into(holder.fotoImageView);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaPokemon(ArrayList<Pokemon> listaPokemon) {
        dataset.addAll(listaPokemon);
        notifyDataSetChanged();
    }


    //Este es parte del adaptador para conseguir los objetos del recycler view
    public class ViewHolder extends RecyclerView.ViewHolder{


        private ImageView fotoImageView;
        private TextView txtNombre;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoImageView = (ImageView) itemView.findViewById(R.id.imageView);
            txtNombre = (TextView) itemView.findViewById(R.id.textView);
        }
    }

}
