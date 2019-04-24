package com.example.mypokerteste.Model.Interface;

import com.example.mypokerteste.Model.PokerDescricao;
import com.example.mypokerteste.Model.PokerModel;
import com.example.mypokerteste.Model.Poker_Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Acesse_Servico {
    @GET("pokemon/")
    Call<PokerModel> getPokerModel();
    @GET("pokemon/{name}")
    Call<PokerDescricao> getPokemon(@Path("name") String name);
}
