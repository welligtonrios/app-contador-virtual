package com.wrios.contadorvirtual2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wrios.contadorvirtual2.R;
import com.wrios.contadorvirtual2.helper.Permissoes;
import com.wrios.contadorvirtual2.model_domain.SolicitacaoSetorFiscal;

import dmax.dialog.SpotsDialog;

public class Cadastrar_SolicitacaoFiscalActivity extends AppCompatActivity {

    private CheckBox idBoxDeclaracao,idBoxDas,idBoxRecalculoImporto,idBoxOtros;
    private EditText idTextDescricao;
    private TextView ideTextSetor;
    private AlertDialog alertDialog;

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


    private SolicitacaoSetorFiscal configirasolicitacao(){

        String declaracao_Faturamento;
        String das_Nacional;
        String recalculoimposto;
        String outros;
        //passar os valores pro objeto
        SolicitacaoSetorFiscal solicitacao = new SolicitacaoSetorFiscal();

        String setor = ideTextSetor.getText().toString();

        //se o box foi selesionado o meu objeto solicitacao recebe ele
        //Declaracao de faturamento
        if (idBoxDeclaracao.isChecked()){
            declaracao_Faturamento = idBoxDeclaracao.getText().toString();
            solicitacao.setDeclarcaoFaturamento(declaracao_Faturamento);
        }
        //Das simples Nacional
        if (idBoxDas.isChecked()){
            das_Nacional = idBoxDas.getText().toString();
            solicitacao.setDasSimplesNacional(das_Nacional);
        }

        //recalculo de impostos
        if (idBoxRecalculoImporto.isChecked()){
             recalculoimposto = idBoxRecalculoImporto.getText().toString();
            solicitacao.setRecalculoImposto(recalculoimposto);
        }
        //outros
        if (idBoxOtros.isChecked()){
             outros = idBoxOtros.getText().toString();
            solicitacao.setOutros(outros);
        }

        String descricao = idTextDescricao.getText().toString();

        solicitacao.setSetor(setor);
        solicitacao.setDescricao(descricao);

        return solicitacao;
    }


    //SALVAR dados
    //validar dados solicitacao
    public void validadarDadosSolicitacao(View view){

          SolicitacaoSetorFiscal solicitacao = configirasolicitacao();  //chamar esse metodo para acionar a descricao e assim validar o preenchimento e tambem passa todos os dados recuperados

        // dialog para aparecer salvando a solicitacao
        alertDialog = new SpotsDialog.Builder().
                setContext(this)
                .setMessage("Salvando solicitação")
                .setCancelable(false)
                .build();


        if (!solicitacao.getDescricao().isEmpty()){
                alertDialog.show();
                alertDialog.dismiss(); // encerrar dialog
                solicitacao.salvar(); // se a descricao for preenchida eu salvo a solicitcao
                voltarAreaSolicitacao(view);
                finish();//encerrar activity

        }else{
            Toast.makeText(Cadastrar_SolicitacaoFiscalActivity.this,"É necessário uma descrição para a solicitação!",
                    Toast.LENGTH_SHORT).show();

        }
    }


    //evento voltar para Area de solicitacao
    public void voltarAreaSolicitacao(View view){
        Intent cadastrarSoli = new Intent(Cadastrar_SolicitacaoFiscalActivity.this, Minhas_SolicitacoesActivity.class);
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
