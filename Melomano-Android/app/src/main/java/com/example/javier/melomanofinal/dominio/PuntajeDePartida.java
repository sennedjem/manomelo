package com.example.javier.melomanofinal.dominio;

/**
 * Created by sebastian on 22/02/16.
 */
public class PuntajeDePartida{
    private String nombre;
    private String genero;
    private Integer puntaje;
    private Integer idPuntaje;

    public PuntajeDePartida() {
    }

    public PuntajeDePartida(final String nombre, final Integer puntaje, final String genero) {
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.genero = genero;
    }

    public boolean estaCompleta() {

        return nombre!=null && genero != null & puntaje !=null;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(final String genero) {
        this.genero = genero;
    }

    public Integer getPuntaje() {
        return this.puntaje;
    }

    public void setPuntaje(final Integer puntaje) {
        this.puntaje = puntaje;
    }

    public Integer getIdPuntaje() {
        return this.idPuntaje;
    }

    public void setIdPuntaje(final Integer idPuntaje) {
        this.idPuntaje = idPuntaje;
    }
}