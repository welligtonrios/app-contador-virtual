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
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.wrios.contadorvirtual2.R;
import com.wrios.contadorvirtual2.helper.ConfiguracaoFirebase;
import com.wrios.contadorvirtual2.model_domain.UsuarioCliente;

public class CadastroActivity extends AppCompatActivity {

    private EditText campoNome, campoEmail, campoSenha;
    private Button botaoCadastrar;
    private ProgressBar progressBar;

    private UsuarioCliente usuarioCliente;

    private FirebaseAuth autenticacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //metodo inicializar componentes
        inicializarComponentes();

        //cadastrar usuario
        progressBar.setVisibility(View.GONE);
        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //verificar se foi preenchido os campos
                String textNome = campoNome.getText().toString();
                String textEmail = campoEmail.getText().toString();
                String textSenha = campoSenha.getText().toString();

                if (!textNome.isEmpty()){
                    if (!textEmail.isEmpty()){
                        if (!textSenha.isEmpty()){
                            //cadastrar
                            //passando o valor dos cmps para os atributos
                            usuarioCliente = new UsuarioCliente();
                            usuarioCliente.setNome(textNome);
                            usuarioCliente.setEmail(textEmail);
                            usuarioCliente.setSenha(textSenha);
                            //metodo cadastrar
                            cadastrarUsuario(usuarioCliente);


                        }else{
                            Toast.makeText(CadastroActivity.this,"Preencha o campo Senha!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(CadastroActivity.this,"Preencha o campo Email!",
                                Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(CadastroActivity.this,"Preencha o campo nome!",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
    /*
     *metodo responsavel por cadastrar o usuarioCliente com os parametros necessarios
     * e fazer validações ao fazer cadastro
     */
    public void cadastrarUsuario(UsuarioCliente usuarioCliente){

        //mostrar o progressbar quando o usuario clicar em salvar
        progressBar.setVisibility(View.VISIBLE);


        //passando para a var autenticao a referencia de autenticao da classe configu...
        autenticacao = ConfiguracaoFirebase.getReferenciaFireAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuarioCliente.getEmail(),
                usuarioCliente.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() { // verficar se foi feita com sucesso o cadastro
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    progressBar.setVisibility(View.GONE);//escondendo o progressBar pois deu certo o cadastro
                    Toast.makeText(CadastroActivity.this,"Cadastrado com sucesso",
                            Toast.LENGTH_SHORT).show();

                    //redireciona para a activity de login
                    Intent iLogin = new  Intent(CadastroActivity.this,AutentinticacaoActivity.class);
                    startActivity(iLogin);
                    finish();
                }else{

                    progressBar.setVisibility(View.GONE); //para de carregar pois precisa tratar o erro
                    //criando um tratmento de excecao
                    String erroExecao ="";
                    try{
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        erroExecao = "Digite uma senha mais forte!";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        erroExecao = "Por favor, digite um e-mail válido";
                    }catch (FirebaseAuthUserCollisionException e){
                        erroExecao = "Esta conta já foi cadastrada: " + e.getMessage();
                    }catch (Exception e){
                        erroExecao = "ao cadastrar usuário: " +  e.getMessage();
                        e.printStackTrace();
                    }
                    //toast para exibir erro excecao
                    Toast.makeText(CadastroActivity.this,"Erro: " + erroExecao,
                            Toast.LENGTH_SHORT).show();

                }

            }
        }); //metodo para cadastrar email e senha


    }

    public void inicializarComponentes(){
        campoNome = findViewById(R.id.idTextNome);
        campoEmail = findViewById(R.id.idTextCNPJEmail);
        campoSenha = findViewById(R.id.idTextSenha);
        botaoCadastrar = findViewById(R.id.idbuttonCadastrar);
        progressBar = findViewById(R.id.idprogressBarCadastro);


    }
}
