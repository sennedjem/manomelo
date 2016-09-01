package com.example.javier.melomanofinal.dominio;

/**
 * Created by sebastian on 22/02/16.
 */
public class Cancion {
    private String nombre;
    private String cancionIncompleta;
    private String primeraPalabra;
    private String segundaPalabra;
    private String palabraIncorrectaUno;
    private String palabraIncorrectaDos;
    private String primerPregunta;
    private String respuestaReal;
    private String genero;
    private Integer idCancion;

    public Cancion() {
    }

    public Cancion(final String nombre, final String canInc, final String pripal, final String segpal, final String primPreg, final String segPreg, final String primResp, final String segResp, final String genero) {
        this.nombre = nombre;
        this.cancionIncompleta = canInc;
        this.primeraPalabra = pripal;
        this.segundaPalabra = segpal;
        this.palabraIncorrectaUno = primPreg;
        this.palabraIncorrectaDos = segPreg;
        this.respuestaReal = primResp;
        this.primerPregunta = segResp;
        this.genero = genero;
    }

    public void equals(final Cancion cancion) {
        this.nombre.equals(cancion.nombre);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getCancionIncompleta() {
        return this.cancionIncompleta;
    }

    public void setCancionIncompleta(final String cancionIncompleta) {
        this.cancionIncompleta = cancionIncompleta;
    }

    public String getPrimeraPalabra() {
        return this.primeraPalabra;
    }

    public void setPrimeraPalabra(final String primeraPalabra) {
        this.primeraPalabra = primeraPalabra;
    }

    public String getSegundaPalabra() {
        return this.segundaPalabra;
    }

    public void setSegundaPalabra(final String segundaPalabra) {
        this.segundaPalabra = segundaPalabra;
    }

    public String getPalabraIncorrectaUno() {
        return this.palabraIncorrectaUno;
    }

    public void setPalabraIncorrectaUno(final String palabraIncorrectaUno) {
        this.palabraIncorrectaUno = palabraIncorrectaUno;
    }

    public String getPalabraIncorrectaDos() {
        return this.palabraIncorrectaDos;
    }

    public void setPalabraIncorrectaDos(final String palabraIncorrectaDos) {
        this.palabraIncorrectaDos = palabraIncorrectaDos;
    }

    public String getPrimerPregunta() {
        return this.primerPregunta;
    }

    public void setPrimerPregunta(final String primerPregunta) {
        this.primerPregunta = primerPregunta;
    }

    public String getRespuestaReal() {
        return this.respuestaReal;
    }

    public void setRespuestaReal(final String respuestaReal) {
        this.respuestaReal = respuestaReal;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(final String genero) {
        this.genero = genero;
    }

    public Integer getIdCancion() {
        return this.idCancion;
    }

    public void setIdCancion(final Integer idCancion) {
        this.idCancion = idCancion;
    }
}