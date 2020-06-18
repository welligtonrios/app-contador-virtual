package com.wrios.contadorvirtual2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wrios.contadorvirtual2.R;

public class Cadastrar_SolicitacaoActivity extends AppCompatActivity {


    private ImageView idsetorFiscal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar__solicitacao);

        idsetorFiscal = findViewById(R.id.idSetorFiscal);

    }



    public void nomesetor(){

    }
}
