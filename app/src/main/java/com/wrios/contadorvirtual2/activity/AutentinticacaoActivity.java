package com.wrios.contadorvirtual2.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.wrios.contadorvirtual2.R;
import com.wrios.contadorvirtual2.helper.ConfiguracaoFirebase;
import com.wrios.contadorvirtual2.model_domain.UsuarioCliente;

public class AutentinticacaoActivity extends AppCompatActivity {

    private Button botaoEntrar;
    private EditText campo_CNPJ_email,campoSenha;
    private ProgressBar progressBarLogin;

    //receperando referencia firebaseAuth
    private FirebaseAuth autenticacao;

    private UsuarioCliente usuarioCliente;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autentinticacao);

        verificarUsuarioLogado();

        //metodo inicializar componetnes
        inicializarComponentes();

        //fazer login de usuario
        progressBarLogin.setVisibility(View.GONE);
        botaoEntrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ///recuperando os campos CNPJ/email e senha
                String cnpj_email = campo_CNPJ_email.getText().toString();
                String senhaLogim = campoSenha.getText().toString();

                //testar se nao estao vazios
                if (!cnpj_email.isEmpty()){

                    //if para o campo senha
                    if (!senhaLogim.isEmpty()){

                        usuarioCliente = new UsuarioCliente();
                        usuarioCliente.setEmail(cnpj_email);
                        usuarioCliente.setSenha(senhaLogim);
                        //metodo que valida login
                        validarLogin(usuarioCliente);

                    }else{
                        Toast.makeText(AutentinticacaoActivity.this,"Preencha o campo CNPJ/Email",
                                Toast.LENGTH_SHORT).show();
                    }
                }else{

                    Toast.makeText(AutentinticacaoActivity.this,"Preencha o campo Senha",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
    /*
     * verificar se o usuario já esta logado*/
    public void verificarUsuarioLogado(){
        autenticacao = ConfiguracaoFirebase.getReferenciaFireAutenticacao();
        if(autenticacao.getCurrentUser() != null){
            //instancio a activity de destino
            startActivity(new Intent(getApplicationContext(), SolicitacaoAreaActivity.class));
            finish();//fecha a activity atual
        }
    }

    /*
     * metodo que irá validar o login de usuario
     * */
    public void validarLogin(UsuarioCliente usuarioCliente){
        progressBarLogin.setVisibility(View.VISIBLE); // acionada o progressbar
        autenticacao = ConfiguracaoFirebase.getReferenciaFireAutenticacao();//passa para o atributo autenticacao a referencia da classe de conf firebase junto com o metodo de autenticacao

        autenticacao.signInWithEmailAndPassword(
                usuarioCliente.getEmail(),
                usuarioCliente.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() { // verificar se foi autenticado
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //caso sucesso ao fazer login usuario
                if (task.isSuccessful()){
                    progressBarLogin.setVisibility(View.GONE);
                    //instancio a activity de destino
                    startActivity(new Intent(getApplicationContext(),SolicitacaoAreaActivity.class));
                    finish();//fecha a activity atual
                }else{
                    Toast.makeText(AutentinticacaoActivity.this,
                            "Erro ao fazer login",
                            Toast.LENGTH_SHORT).show();
                    progressBarLogin.setVisibility(View.GONE);
                }


            }
        });
    }



    public void inicializarComponentes(){
        botaoEntrar = findViewById(R.id.idbuttonEntrar);
        campo_CNPJ_email = findViewById(R.id.idTextCNPJEmailEntrar);
        campoSenha = findViewById(R.id.idTextSenhaEntrar);
        progressBarLogin = findViewById(R.id.idprogressBarEntrar);
    }
}
