package com.wrios.contadorvirtual2.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wrios.contadorvirtual2.R;
import com.wrios.contadorvirtual2.helper.Permissoes;

public class Cadastrar_SolicitacaoFiscalActivity extends AppCompatActivity {

    private CheckBox idBoxDeclaracao,idBoxDas,idBoxRecalculoImporto,idBoxOtros;
    private EditText idTextDescricao;
    private TextView ideTextSetor;

    //array de permissoes
    private String[] permissoes = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar__solicitacao_fiscal);

        iniciailizarId(); //inicializar campos

        //validar permissoes   metodo validar da classe permissoes
        Permissoes.validarPermissoes(permissoes,this,1);

    }


    //validar dados solicitacao
    public void validadarDadosSolicitacao(View view){
        String estadoDescricao = idTextDescricao.getText().toString();

        if (!estadoDescricao.isEmpty()){
            //salvarSolicitacao(); // se a descricao for preenchida eu salvo a solicitcao
        }else{
            Toast.makeText(Cadastrar_SolicitacaoFiscalActivity.this,"É necessário uma descrição para a solicitação!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    //salvar solicitacao
    public void salvarSolicitcao(){
        
        String Setor = ideTextSetor.getText().toString();
        String declaracao_Faturamento = idBoxDeclaracao.getText().toString() ;
        String das_Nacional = idBoxDas.getText().toString();
        String recalculoimposto = idBoxRecalculoImporto.getText().toString();
        String outros = idBoxOtros.getText().toString();
        String descricao = idTextDescricao.getText().toString();


    }



    //evento voltar para Area de solicitacao
    public void voltarAreaSolicitacao(View view){
        Intent cadastrarSoli = new Intent(Cadastrar_SolicitacaoFiscalActivity.this, SolicitacaoAreaActivity.class);
        startActivity(cadastrarSoli);
    }

    //inicializa componentes
    private void iniciailizarId(){
        ideTextSetor = findViewById(R.id.idtextSetor);
        idBoxDeclaracao = findViewById(R.id.idBoxDeclaracao);
        idBoxDas = findViewById(R.id.idBoxDas);
        idBoxRecalculoImporto = findViewById(R.id.idBoxRecalculo);
        idBoxOtros = findViewById(R.id.idBoxOutros);
        idTextDescricao = findViewById(R.id.idTextDescricao);
    }




}
