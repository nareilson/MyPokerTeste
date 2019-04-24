package com.example.mypokerteste;

import android.graphics.Interpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mypokerteste.Model.API_Cliente_Retrof;
import com.example.mypokerteste.Model.Interface.Acesse_Servico;
import com.example.mypokerteste.Model.PokerDescricao;
import com.example.mypokerteste.Model.Poker_Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DescricaoActivity extends AppCompatActivity {

    ImageView vrImgPerfil;
    TextView vrName;
    TextView vrPeso;
    TextView vrAltura;
    TextView vrDemaisDados;
    Poker_Result result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao);


        vrImgPerfil = findViewById(R.id.imageViewPerfil);
        vrName = findViewById(R.id.textViewName);
        vrAltura = findViewById(R.id.textViewAltura);
        vrPeso = findViewById(R.id.textViewPeso);
        vrDemaisDados = findViewById(R.id.textViewMaisDados);


        Bundle dados = getIntent().getExtras();
        if(dados.get("op") != null){
            result = (Poker_Result) dados.getSerializable("op");

        }

        Call<PokerDescricao> call = API_Cliente_Retrof.acesso().create(Acesse_Servico.class).getPokemon(result.getName());
        call.enqueue(new Callback<PokerDescricao>() {
            @Override
            public void onResponse(Call<PokerDescricao> call, Response<PokerDescricao> response) {
                if(response.isSuccessful()){
                    vrName.setText(response.body().getName());
                    vrAltura.setText(response.body().getWeight().toString());
                    vrPeso.setText(response.body().getHeight().toString());
                    vrDemaisDados.setText(response.body().getBaseExperience().toString());
                    Glide.with(DescricaoActivity.this)
                            .load(response.body().getSprites().getFrontDefault())
                            .into(vrImgPerfil);
                    Log.e("IMAGEM",response.body().getSprites()+"");
                }

            }

            @Override
            public void onFailure(Call<PokerDescricao> call, Throwable t) {

            }
        });


    }
}
