package com.example.javier.melomanofinal;

/**
 * Created by Javier on 19/02/2016.
 */
public class CancionRep {

    private String palabraCorrectaUno;
    private String palabraCorrectaDos;
    private String palabraIncorrectaUno;
    private String palabraIncorrectaDos;
    public CancionRep(String correctaUno, String correcta2, String incorrecta1, String incorrecta2){
        this.palabraCorrectaUno= correctaUno;
        this.palabraCorrectaDos= correcta2;
        this.palabraIncorrectaUno=incorrecta1;
        this.palabraCorrectaDos=incorrecta2;
    }

    public CancionRep() {

    }


    public void setPalabraCorrectaUno(String palabra) {this.palabraCorrectaUno=palabra;}
    public void setPalabraCorrectaDos(String palabra) {this.palabraCorrectaDos=palabra;}
    public void setPalabraIncorrectaUno(String palabra) {this.palabraIncorrectaUno=palabra;}
    public void setPalabraIncorrectaDos(String palabra) {this.palabraIncorrectaDos=palabra;}

    public String getPalabraCorrectaUno() {return palabraCorrectaUno;}
    public String getPalabraCorrectaDos() {return palabraCorrectaDos;}
    public String getPalabraIncorrectaUno() {return palabraIncorrectaUno;}
    public String getPalabraIncorrectaDos() {
        return palabraIncorrectaDos;
    }





}
