package com.example.mypokerteste.Model;

import com.example.mypokerteste.Model.Interface.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API_Cliente_Retrof {

private static Retrofit retrofit;
    public static Retrofit acesso(){

        if(retrofit==null) {
            final OkHttpClient.Builder okhttp = new OkHttpClient.Builder();
            okhttp.connectTimeout(Constants.TIME_OUT, TimeUnit.SECONDS);
            okhttp.readTimeout(Constants.TIME_OUT, TimeUnit.SECONDS);
            okhttp.callTimeout(Constants.TIME_OUT, TimeUnit.SECONDS);
            okhttp.writeTimeout(Constants.TIME_OUT, TimeUnit.SECONDS);

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.URL_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okhttp.build())
                    .build();
        }
        return retrofit;
    }
}
