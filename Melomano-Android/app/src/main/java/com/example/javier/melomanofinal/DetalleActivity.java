package com.example.javier.melomanofinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by Javier on 04/02/2016.
 */
public class DetalleActivity extends AppCompatActivity {
    public static final String EXTRA_URL = "url";
    private String genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getBoolean(R.bool.dual_plane)) {
            finish();
            return;
        }


        this.genero = getIntent().getStringExtra("genero");

        setContentView(R.layout.activity_detalle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String url = extras.getString(EXTRA_URL);

            MuestraCancionFragment detailFragment = (MuestraCancionFragment) getSupportFragmentManager().findFragmentById(R.id.detalleFragment);
            detailFragment.setFragmentPorGenero(genero);
        }
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbarDetail);
        myToolbar.setTitle(genero);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void terminoJugada(int i){
        Intent intent = new Intent(this, PartidaTerminadaActivity.class);
        intent.putExtra("genero", genero);
        intent.putExtra("puntaje", i);
        startActivity(intent);
        finish();
    }
}
