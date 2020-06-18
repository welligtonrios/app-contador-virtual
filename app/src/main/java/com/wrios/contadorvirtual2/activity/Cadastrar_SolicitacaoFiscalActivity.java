package com.wrios.contadorvirtual2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wrios.contadorvirtual2.R;

public class Cadastrar_SolicitacaoFiscalActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar__solicitacao_fiscal);

       TextView idSetor = findViewById(R.id.idtextSetor);

       SolicitacaoAreaActivity so = new SolicitacaoAreaActivity();



    }


    //evento voltar para Area de solicitacao

    public void voltarAreaSolicitacao(View view){
        Intent cadastrarSoli = new Intent(Cadastrar_SolicitacaoFiscalActivity.this, SolicitacaoAreaActivity.class);
        startActivity(cadastrarSoli);
    }


}
