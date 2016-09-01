package com.example.javier.melomanofinal.clienteRest;

import com.example.javier.melomanofinal.dominio.Cancion;
import com.example.javier.melomanofinal.dominio.PuntajeDePartida;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by Javier on 19/02/2016.
 */
    public interface MelomanoService {

   @GET("/generos")
    void getGeneros(Callback<List<String>> callback);

    @GET("/canciones/{genero}")
    void getCancionPorGenero(@Path("genero") String genero, Callback<List<Cancion>> callback);

    @GET("/puntajes")
    void getPuntaje(Callback<List<PuntajeDePartida>> callback);

    @GET("/puntajes/{generos}")
    void getPuntajePorGenero(@Path("generos")String genero,Callback<List<PuntajeDePartida>>callback);

    @POST("/puntajess")
    void setPuntaje(@Body PuntajeDePartida task, Callback<Boolean> cb);
}
