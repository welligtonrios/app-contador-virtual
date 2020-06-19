package com.wrios.contadorvirtual2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.wrios.contadorvirtual2.R;

public class Cadastrar_SolicitacaoFiscalActivity extends AppCompatActivity {

    private CheckBox idBoxDeclaracao,idBoxDas,idBoxRecalculoImporto,idBoxOtros;
    private EditText idTextDescricao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar__solicitacao_fiscal);

        iniciailizarId(); //inicializar campos

    }

    //metodo salvar solicitacao
    public void salvarSolicitacao(View view){



    }


    //evento voltar para Area de solicitacao

    public void voltarAreaSolicitacao(View view){
        Intent cadastrarSoli = new Intent(Cadastrar_SolicitacaoFiscalActivity.this, SolicitacaoAreaActivity.class);
        startActivity(cadastrarSoli);
    }

    //inicializa componentes
    private void iniciailizarId(){
        idBoxDeclaracao = findViewById(R.id.idBoxDeclaracao);
        idBoxDas = findViewById(R.id.idBoxDas);
        idBoxRecalculoImporto = findViewById(R.id.idBoxRecalculo);
        idBoxOtros = findViewById(R.id.idBoxOutros);
        idTextDescricao = findViewById(R.id.idTextDescricao);
    }


}
