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
import com.wrios.contadorvirtual2.model_domain.SolicitacaoSetorFiscal;

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



    //salvar solicitacao
    public void salvarSolicitcao(){

        

    }

    private SolicitacaoSetorFiscal configirasolicitacao(){
        String setor = ideTextSetor.getText().toString();
        String declaracao_Faturamento = idBoxDeclaracao.getText().toString() ;
        String das_Nacional = idBoxDas.getText().toString();
        String recalculoimposto = idBoxRecalculoImporto.getText().toString();
        String outros = idBoxOtros.getText().toString();
        String descricao = idTextDescricao.getText().toString();

        SolicitacaoSetorFiscal solicitacao = new SolicitacaoSetorFiscal();

        solicitacao.setSetor(setor);
        solicitacao.setDeclarcaoFaturamento(declaracao_Faturamento);
        solicitacao.setDasSimplesNacional(das_Nacional);
        solicitacao.setRecalculoImposto(recalculoimposto);
        solicitacao.setOutros(outros);
        solicitacao.setDescricao(descricao);

        return solicitacao;
    }



    //validar dados solicitacao
    public void validadarDadosSolicitacao(View view){

          SolicitacaoSetorFiscal solicitacao = configirasolicitacao();  //chamar esse metodo para acionar a descricao e assim validar o preenchimento

        if (!solicitacao.getDescricao().isEmpty()){
                salvarSolicitcao(); // se a descricao for preenchida eu salvo a solicitcao
        }else{
            Toast.makeText(Cadastrar_SolicitacaoFiscalActivity.this,"É necessário uma descrição para a solicitação!",
                    Toast.LENGTH_SHORT).show();
        }
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
