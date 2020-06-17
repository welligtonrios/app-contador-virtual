package com.wrios.contadorvirtual2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.wrios.contadorvirtual2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //diminuir o tempo da splash activity para três segundos

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                abrirAutenticacao();
            }
        },3000);

    }


    //chamando a activity autenticação

    private void abrirAutenticacao(){
       Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);
        //para fechar a minha SplashActivity
        finish(); //finaliza a activty atual





    }
}
