package com.example.mypokerteste;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //componente responsavel por chamar uma metodo apos o tempo definido em MilliSegundos
        handler.postDelayed(this::Splash_Tela,2000);
    }

    public void Splash_Tela(){
        Intent intent = new Intent(SplashActivity.this,MainActivity.class);
        startActivity(intent);
    }

}
