package com.example.javier.melomanofinal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity  implements ListGenero.OnGenreSelectedListener {

    TextView GenSeleccionado;
    EditText GenIngresado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.GenIngresado = (EditText) findViewById(R.id.editText);


        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbarTotalMain);
        toolbar.setTitle("Elección Genero");
        setSupportActionBar(toolbar);


    }


    @Override
    public void onGenreSelected(String genero) {
        Intent intent = new Intent(this, DetalleActivity.class);
        intent.putExtra("genero", genero);
        startActivity(intent);

    }

    @Override
    public void pasarGeneros(List<String> generos) {

    }
}