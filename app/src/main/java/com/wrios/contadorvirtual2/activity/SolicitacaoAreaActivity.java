package com.wrios.contadorvirtual2.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.wrios.contadorvirtual2.R;
import com.wrios.contadorvirtual2.helper.ConfiguracaoFirebase;

public class SolicitacaoAreaActivity extends AppCompatActivity {
    //variavel toolbar
    private Toolbar toolbar;

    private FirebaseAuth autenticacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitacao_area);


        //configurando toolbar
         this.toolbar = findViewById(R.id.toolbarPrincial);
         toolbar.setTitle("Area de colicitação");
         setSupportActionBar(toolbar);

         //config objetos
        autenticacao = ConfiguracaoFirebase.getReferenciaFireAutenticacao(); //passa a referencia firebaseautentica para variavel autenticacao

    }

        //menus
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            //criando MenuInflater para passar o menu / 1 para o menu xml criado e segundo o obj menu de oncreate
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.menu_configuracao_usuario,menu);

            return super.onCreateOptionsMenu(menu);
        }

        //tratamentos para os menus
        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //tramento as opções
            switch (item.getItemId()){
                case R.id.menu_cliente: break;
                case R.id.menu_solicitações: break;
                case  R.id.menu_geral: break;
                case R.id.menu_conta: break;
                case R.id.menu_privacidade_: break;
                case R.id.menu_sair:
                    //caso o usuario saia ele ira pra tela de login
                    deslogarUsuario();
                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                    break;
            }

            return super.onOptionsItemSelected(item);
        }

        private void deslogarUsuario(){
                try{
                    autenticacao.signOut(); //metodo que desloga usuario
                }catch (Exception e){
                    e.printStackTrace();
                }
        }

        //abrindo chamado para setor fiscal
        public void carregarSetorFiscal(View view){
            Intent cadastrarSoli = new Intent(SolicitacaoAreaActivity.this, Cadastrar_SolicitacaoFiscalActivity.class);
            startActivity(cadastrarSoli);
            finish();

        }

        //abrindo chamado para setor Pessoal
        public void carregarSetorPessoal(View view){
            Intent cadastrarSoli = new Intent(SolicitacaoAreaActivity.this, Cadastrar_solicitacao_SetorPessoalActivity.class);
            startActivity(cadastrarSoli);
            finish();

        }


}
