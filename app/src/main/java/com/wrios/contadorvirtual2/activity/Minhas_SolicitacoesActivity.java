package com.wrios.contadorvirtual2.activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import com.wrios.contadorvirtual2.R;

public class Minhas_SolicitacoesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minhas__solicitacoes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cadastrarSoli = new Intent(Minhas_SolicitacoesActivity.this, SolicitacaoAreaActivity.class);
                startActivity(cadastrarSoli);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
