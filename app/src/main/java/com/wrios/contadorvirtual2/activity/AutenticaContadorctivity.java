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
import com.google.firebase.database.DatabaseReference;
import com.wrios.contadorvirtual2.R;
import com.wrios.contadorvirtual2.helper.ConfiguracaoFirebase;
import com.wrios.contadorvirtual2.model_domain.UsuarioCliente;
import com.wrios.contadorvirtual2.model_domain.UsuarioContador;

public class AutenticaContadorctivity extends AppCompatActivity {


    private Button botaoEntrar;
    private EditText campoNome,campoSenha;
    private ProgressBar progressBarLogin;

    private UsuarioContador usuarioContador;

    private DatabaseReference autenticao;

    //receperando referencia firebaseAuth
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autentica_contadorctivity);

        //incialicar componentes
        inicializarComponentes();

        //fazer login de usuario
        progressBarLogin.setVisibility(View.GONE);

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //recuperar os campos
                String nome = campoNome.getText().toString();
                String senha = campoSenha.getText().toString();
                //testar se nao estao vazios
                if (!nome.isEmpty()){


                    if(!senha.isEmpty()){

                        usuarioContador = new UsuarioContador();
                        usuarioContador.setNome(nome);
                       usuarioContador.setSenhaContador(senha);

                        //validarLogin
                        validarLogimContador(usuarioContador);

                    }else {
                        Toast.makeText(AutenticaContadorctivity.this,"Preencha o campo Senha",
                                Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(AutenticaContadorctivity.this,"Preencha o campo Nome",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });


        }

    /*
     * metodo que irá validar o login de usuario
     * */
    public void validarLogimContador(UsuarioContador usuarioContador){
        progressBarLogin.setVisibility(View.VISIBLE); // acionada o progressbar
        autenticacao = ConfiguracaoFirebase.getReferenciaFireAutenticacao();//passa para o atributo autenticacao a referencia da classe de conf firebase junto com o metodo de autenticacao

        autenticacao.signInWithEmailAndPassword(
                usuarioContador.getNome(),
                usuarioContador.getsenhaContador()
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
                    Toast.makeText(AutenticaContadorctivity.this,
                            "Erro ao fazer login",
                            Toast.LENGTH_SHORT).show();
                    progressBarLogin.setVisibility(View.GONE);
                }


            }
        });
    }


    public void inicializarComponentes(){
        botaoEntrar = findViewById(R.id.idbuttonEntrarContador);
        campoNome = findViewById(R.id.campo_NomeEntrarContador);
        campoSenha = findViewById(R.id.idTextSenhaEntrarContador);
        progressBarLogin = findViewById(R.id.idprogressBarEntrarContador);
    }


}