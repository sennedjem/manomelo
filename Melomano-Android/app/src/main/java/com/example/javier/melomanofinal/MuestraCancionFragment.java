package com.example.javier.melomanofinal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.javier.melomanofinal.clienteRest.ConexionServidor;
import com.example.javier.melomanofinal.clienteRest.MelomanoService;
import com.example.javier.melomanofinal.dominio.Cancion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Javier on 04/02/2016.
 */
public class MuestraCancionFragment extends Fragment implements View.OnClickListener {
    TextView cancionIncompleta;
    private int puntaje2;
    Button opcion1;
    Button opcion2;
    Button opcion3;
    Button opcion4;
    Button nombreCancion1;
    Button nombreCancion2;
    Cancion cancion;
    List<Cancion> canciones;
    String palabraAComparar;
    private int palabrasIngresadas = 0;
    private int preguntasContestadas = 0;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.muestra_cancion, container, false);


        return view;

    }

    public void setFragmentPorGenero(String genero) {
        ponerReferenciasALosBotones(genero);
        this.obtenerCanciones(genero);

    }

    public void ponerReferenciasALosBotones(String genero) {
        this.cancionIncompleta = ((TextView) getView().findViewById(R.id.cancion));
        this.opcion1 = ((Button) getView().findViewById(R.id.opcion));
        opcion1.setOnClickListener(this);
        this.opcion2 = ((Button) getView().findViewById(R.id.opcionDos));
        opcion2.setOnClickListener(this);
        this.opcion3 = ((Button) getView().findViewById(R.id.opcionTres));
        opcion3.setOnClickListener(this);
        this.opcion4 = ((Button) getView().findViewById(R.id.opcionCuatro));
        opcion4.setOnClickListener(this);
        this.nombreCancion1 = ((Button) getView().findViewById(R.id.nombreCancion1));
        nombreCancion1.setOnClickListener(this);
        this.nombreCancion2 = ((Button) getView().findViewById(R.id.nombreCancion2));
        nombreCancion2.setOnClickListener(this);
        puntaje2 = 0;
    }

    private void obtenerCanciones(String genero) {
        MelomanoService mserv = ConexionServidor.createMelomanoService();
        mserv.getCancionPorGenero(getActivity().getIntent().getStringExtra("genero").toLowerCase(), new Callback<List<Cancion>>() {
            @Override
            public void success(List<Cancion> cancions, Response response) {
                canciones = cancions;
                cancion = canciones.get(0);
                if (cancion != null) {
                    rellenarCampos(cancion);
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }

    public void rellenarCampos(Cancion c) {
        this.cancionIncompleta.setText(cancion.getCancionIncompleta());
        randombotones();
        this.palabraAComparar = cancion.getPrimeraPalabra();
        this.preguntasContestadas = 0;
        this.palabrasIngresadas = 0;
    }

    private void randombotones() {
        List<Button> botonespalabra = new ArrayList<>();
        botonespalabra.add(opcion1);
        botonespalabra.add(opcion2);
        botonespalabra.add(opcion3);
        botonespalabra.add(opcion4);
        List<Button> botonescancion = new ArrayList<>();
        botonescancion.add(nombreCancion1);
        botonescancion.add(nombreCancion2);
        List<String> palabras = new ArrayList<String>();
        palabras.add(cancion.getPrimeraPalabra());
        palabras.add(cancion.getSegundaPalabra());
        palabras.add(cancion.getPalabraIncorrectaUno());
        palabras.add(cancion.getPalabraIncorrectaDos());
        List<String> cancionnombres = new ArrayList<String>();
        cancionnombres.add(cancion.getNombre());
        cancionnombres.add(cancion.getPrimerPregunta());
        long seed = System.nanoTime();
        Collections.shuffle(botonespalabra, new Random(seed));
        Collections.shuffle(botonescancion, new Random(seed));
        for(int i=0; i<botonespalabra.size(); i++){
            botonespalabra.get(i).setText(palabras.get(i));

        }
        for(int i=0; i<botonescancion.size(); i++){
            botonescancion.get(i).setText(cancionnombres.get(i));

        }
    }

    public void onClick(View v) {
        Button b = (Button) v;
        v.setVisibility(View.INVISIBLE);
        if (esUnBotonDePregunta(v)) {
            if (validarPregunta(b)) {
                puntaje2 = puntaje2 + 4;
                desabilitarBotonesDePreguntas();
            }
        } else {

            if (this.validar(b)) {
                puntaje2 = puntaje2 + 2;

            }
            actualizarPalabraAComparar();

        }
        verSiHayQueActualizarCancion();
        verSiNoTerminoPartida();
    }

    private void desabilitarBotonesDePreguntas() {
        nombreCancion1.setVisibility(View.INVISIBLE);
        nombreCancion2.setVisibility(View.INVISIBLE);
    }

    private void verSiHayQueActualizarCancion() {
        if (palabrasIngresadas >= 2 && preguntasContestadas == 1 && !(cancion.getNombre().equals(canciones.get(4).getNombre())))
        { actualizarCancion();
        habilitarBotones();}
    }

    private void habilitarBotones() {
        opcion1.setVisibility(View.VISIBLE);
        opcion2.setVisibility(View.VISIBLE);
        opcion3.setVisibility(View.VISIBLE);
        opcion4.setVisibility(View.VISIBLE);
        nombreCancion1.setVisibility(View.VISIBLE);
        nombreCancion2.setVisibility(View.VISIBLE);
    }

    private boolean validarPregunta(Button b) {
        preguntasContestadas = preguntasContestadas + 1;
        return cancion.getNombre().equals(b.getText()) && preguntasContestadas == 1;
    }

    public boolean esUnBotonDePregunta(View v) {

        return v == nombreCancion1 || v == nombreCancion2;
    }

    private void actualizarCancion() {
        cancion = canciones.get((canciones.indexOf(cancion) + 1));
        rellenarCampos(cancion);
    }

    private boolean validar(Button b) {
        palabrasIngresadas = palabrasIngresadas + 1;
        if (palabrasIngresadas == 2) {
            desabilitarOpcionesDePalabras();
        }
        return palabraAComparar.equals(b.getText()) && palabrasIngresadas < 3;
    }

    private void desabilitarOpcionesDePalabras() {
        opcion1.setVisibility(View.INVISIBLE);
        opcion2.setVisibility(View.INVISIBLE);
        opcion3.setVisibility(View.INVISIBLE);
        opcion4.setVisibility(View.INVISIBLE);

    }

    private void verSiNoTerminoPartida() {
        if (palabrasIngresadas >= 2 && preguntasContestadas >= 1 && cancion.getNombre().equals(canciones.get(4).getNombre())) {
            DetalleActivity activity = (DetalleActivity) getActivity();
            activity.terminoJugada(puntaje2);
        }
    }

    private void actualizarPalabraAComparar() {

        if (palabraAComparar.equals(cancion.getPrimeraPalabra())) {
            palabraAComparar = cancion.getSegundaPalabra();
        }


    }
}

