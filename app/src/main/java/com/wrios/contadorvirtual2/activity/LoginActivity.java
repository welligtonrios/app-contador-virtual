package com.wrios.contadorvirtual2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wrios.contadorvirtual2.R;

public class LoginActivity extends AppCompatActivity {

    private Button botaoLogin;
    private Button botaoCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        botaoLogin = findViewById(R.id.idbuttonLogin);
        botaoCadastrar = findViewById(R.id.idbuttonCadastrar);

    }

    //chamando a activity autenticaçãoLogin
    public void atenticarLogin(View view){
        Intent iLogin = new  Intent(LoginActivity.this,AutentinticacaoActivity.class);
        startActivity(iLogin);
        finish();
    }

    //chamando a activity autenticaçãoLogin
    public void Cadastrar(View view){

        Intent iCadastrar = new Intent(LoginActivity.this,CadastroActivity.class);
        startActivity(iCadastrar);
        finish();
    }


}

