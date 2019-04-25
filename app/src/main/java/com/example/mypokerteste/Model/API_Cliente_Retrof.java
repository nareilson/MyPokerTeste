package com.example.mypokerteste.Model;

import com.example.mypokerteste.Model.Interface.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API_Cliente_Retrof {

    public static Retrofit acesso(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
