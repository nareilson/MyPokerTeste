package com.example.mypokerteste;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.mypokerteste.Model.API_Cliente_Retrof;
import com.example.mypokerteste.Model.Interface.Acesse_Servico;
import com.example.mypokerteste.Model.Interface.OnClick;
import com.example.mypokerteste.Model.PokerModel;
import com.example.mypokerteste.Model.Poker_Result;
import com.example.mypokerteste.Utils.ListAdapter_PokerModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Poker_Result> listaPoker = new ArrayList<>();
    ListAdapter_PokerModel listAdpter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerViewPricipal);

        getPoker();
    }

    public void getPoker(){
        Call<PokerModel> call = API_Cliente_Retrof.acesso().create(Acesse_Servico.class).getPokerModel();
        call.enqueue(new Callback<PokerModel>() {
            @Override
            public void onResponse(@NonNull Call<PokerModel> call,@NonNull Response<PokerModel> response) {
                if(response.isSuccessful()){
                    Log.i("Response","Response sucesso");
                    Log.e("body", response.body().getResults().toString());
                    listaPoker.addAll(response.body().getResults());

                    Log.e("addall", listaPoker.toString());

//                    for (Poker_Result i:listaPoker){
//                        Log.e("Pokemon Nome: ",i.getName());
//                        listaPoker.add(i);
//                    }
//
//
                    listAdpter = new ListAdapter_PokerModel(MainActivity.this,listaPoker, item -> {
                        Toast.makeText(MainActivity.this,item.getName(),Toast.LENGTH_LONG).show();Intent intent = new Intent(MainActivity.this, DescricaoActivity.class);
                        intent.putExtra("op", item);
                        startActivity(intent);
                    });
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(listAdpter);


                }


            }

            @Override
            public void onFailure(Call<PokerModel> call, Throwable t) {
                Log.i("ERRO","Responde sucesso");
            }
        });
    }
}
