package com.example.javier.melomanofinal;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.example.javier.melomanofinal.adapter.GenerosAdapter;
import com.example.javier.melomanofinal.clienteRest.ConexionServidor;
import com.example.javier.melomanofinal.clienteRest.MelomanoService;
import com.example.javier.melomanofinal.dominio.PuntajeDePartida;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Javier on 01/02/2016.
 */
public class ListGenero extends Fragment {
    private OnGenreSelectedListener listener;
    private List<String> generos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.lista_genero,
                container, false);
        final ListGenero fragment = this;
        MelomanoService meServices = ConexionServidor.createMelomanoService();
        meServices.getGeneros(new Callback<List<String>>() {
            @Override
            public void success(List<String> genres, Response response) {
                GridView lista = (GridView) view.findViewById(R.id.listageneros);
                GenerosAdapter listaAdaptada = new GenerosAdapter(fragment, genres);
                lista.setAdapter(listaAdaptada);
                generos = genres;
                pasarGeneros(genres);


            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

        return view;
    }

    public void armarLista(List<String> generos) {
        GridView lista = (GridView) getView().findViewById(R.id.listageneros);
        //ListDisciplinasAdapter listaAdaptada = new ListDisciplinasAdapter(this, disciplinas);
        //lista.setAdapter(listaAdaptada);
        ((GenerosAdapter)lista.getAdapter()).setGeneros(generos);
        ((GenerosAdapter)lista.getAdapter()).notifyDataSetChanged();
    }

    public interface OnGenreSelectedListener {
        void onGenreSelected(String genero);
        void pasarGeneros(List<String> generos);
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        if (context instanceof OnGenreSelectedListener) {
            listener = (OnGenreSelectedListener) context;

        } else {
            throw new ClassCastException(context.toString()
                    + " must implement GenreListFragment.OnGenreSelectedListener");
        }
    }

    public void tellTheListenerThatAGenreWasSelected(String genero) {
        listener.onGenreSelected(genero);
    }

    public void pasarGeneros(List<String> generos){

        getView().findViewById(R.id.generoeleccion).setVisibility(View.VISIBLE);
        getView().findViewById(R.id.loadGenero).setVisibility(View.INVISIBLE);
        listener.pasarGeneros(generos);
    }


}
