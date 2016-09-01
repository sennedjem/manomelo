package com.example.javier.melomanofinal.adapter;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.javier.melomanofinal.ListGenero;
import com.example.javier.melomanofinal.R;

import java.util.List;

/**
 * Created by Javier on 01/02/2016.
 */
public class GenerosAdapter extends BaseAdapter{

    private final Fragment context;
    private  List<String> generos;
    private ListGenero listener;

    public GenerosAdapter(Fragment context, List<String> generos){

        this.context = context;
        this.generos = generos;
        this.listener =(ListGenero)context;

    }



    @Override
    public int getCount() {
        return generos.size();
    }

    @Override
    public String getItem(int position) {
        return generos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context.getActivity()).inflate(R.layout.item, parent, false);
        final String genero = getItem(position);
        setContenido(view, genero);
        setOnClick(view, genero);
        return view;
    }

    private void setOnClick(View view, final String genero) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.tellTheListenerThatAGenreWasSelected(genero);
            }
        });
    }

    private void setContenido(View view, String genero) {
        TextView generoView = (TextView) view.findViewById(R.id.texto);
        generoView.setText(genero);
        ImageView imagenGeneroView = (ImageView) view.findViewById(R.id.imagen_genero);
        Glide.with(imagenGeneroView.getContext())
                .load(idImagenGenero(genero))
                .into(imagenGeneroView);
    }

    private int idImagenGenero(String genero){
        int id = 0;
        switch (genero){
            case "Rock" : id = R.drawable.rock;
                break;
            case "Tango" : id = R.drawable.tango;
                break;
            case "Cumbia" : id = R.drawable.cumbia;
                break;
            case "Pop" : id = R.drawable.pop;
                break;
            case "Electronica" : id = R.drawable.electronica;
                break;
            case "Rap" : id = R.drawable.rap;
                break;
        }

        return id;
    }
    public void setGeneros(List<String> generos){
        this.generos = generos;
    }

}
