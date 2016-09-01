package com.example.javier.melomanofinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

    }

    public void jugar(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void abrirActivityRanking(View v){
        Intent i = new Intent(this, RankingTotalActivity.class);
        startActivity(i);
    }

}
