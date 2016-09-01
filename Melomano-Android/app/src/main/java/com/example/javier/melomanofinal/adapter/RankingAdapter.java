package com.example.javier.melomanofinal.adapter;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.javier.melomanofinal.R;
import com.example.javier.melomanofinal.RankingFragment;
import com.example.javier.melomanofinal.dominio.PuntajeDePartida;

import java.util.List;

/**
 * Created by sebastian on 22/02/16.
 */
public class RankingAdapter extends BaseAdapter {

    private final Fragment context;
    private final List<PuntajeDePartida> puntajes;
    private RankingFragment listener;

    public RankingAdapter(Fragment context, List<PuntajeDePartida> puntajes){

        this.context = context;
        this.puntajes = puntajes;
        this.listener =(RankingFragment)context;

    }



    @Override
    public int getCount() {
        return puntajes.size();
    }

    @Override
    public PuntajeDePartida getItem(int position) {
        return puntajes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context.getActivity()).inflate(R.layout.itemranking, parent, false);
        final PuntajeDePartida puntaje = getItem(position);
        setContenido(view, puntaje);
        setOnClick(view, puntaje);
        return view;
    }

    private void setOnClick(View view, final PuntajeDePartida puntaje) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void setContenido(View view, PuntajeDePartida puntaje) {
        TextView nombreJugadorView = (TextView) view.findViewById(R.id.nombrejugador);
        nombreJugadorView.setText(puntaje.getNombre().toUpperCase());
        TextView generoView = (TextView) view.findViewById(R.id.genero);
        generoView.setText(puntaje.getGenero());
        TextView puntajeView = (TextView) view.findViewById(R.id.puntaje);
        puntajeView.setText(""+puntaje.getPuntaje());


    }
}