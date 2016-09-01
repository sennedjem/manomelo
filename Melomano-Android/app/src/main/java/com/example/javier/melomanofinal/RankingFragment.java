package com.example.javier.melomanofinal;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.javier.melomanofinal.adapter.RankingAdapter;
import com.example.javier.melomanofinal.clienteRest.ConexionServidor;
import com.example.javier.melomanofinal.clienteRest.MelomanoService;
import com.example.javier.melomanofinal.dominio.PuntajeDePartida;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RankingFragment extends Fragment {


    private RankingFragmentListener listener;
    public RankingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_ranking,
                container, false);

        return view;

    }

    public void armarLista() {
        MelomanoService meServices = ConexionServidor.createMelomanoService();
        meServices.getPuntaje(new Callback<List<PuntajeDePartida>>() {
            @Override
            public void success(List<PuntajeDePartida> pjs, Response response) {
                armarlista(pjs,getView());

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public void armarlista(List<PuntajeDePartida> puntajes,View v ){
        getView().findViewById(R.id.layoutcarga).setVisibility(View.INVISIBLE);
        getView().findViewById(R.id.layoutranking).setVisibility(View.VISIBLE);
        ListView lista = (ListView) v.findViewById(R.id.rankinglview);
        RankingAdapter listaAdaptada = new RankingAdapter( this, puntajes);
        lista.setAdapter(listaAdaptada);
    }

    public void armarlista(String genero ){
        MelomanoService meServices = ConexionServidor.createMelomanoService();
        meServices.getPuntajePorGenero(genero, new Callback<List<PuntajeDePartida>>() {
            @Override
            public void success(List<PuntajeDePartida> pjs, Response response) {
                armarlista(pjs, getView());

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        if (context instanceof RankingFragmentListener) {
            listener = (RankingFragmentListener) context;
            listener.onFragmentCreate(this);
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement GenreListFragment.OnGenreSelectedListener");
        }
    }

    public interface RankingFragmentListener {
        void onFragmentCreate(RankingFragment fragment);
    }
}
