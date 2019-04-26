package com.example.mypokerteste;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.mypokerteste.Model.API_Cliente_Retrof;
import com.example.mypokerteste.Model.Interface.Acesse_Servico;
import com.example.mypokerteste.Model.PokerModel;
import com.example.mypokerteste.Model.Poker_Result;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModel extends android.arch.lifecycle.ViewModel {
MutableLiveData<ArrayList<Poker_Result>> pokeLiveDatas;
ArrayList<Poker_Result> pokerList;

public LiveData<ArrayList<Poker_Result>> getPokers(){
    if(pokeLiveDatas == null){
        pokeLiveDatas = new MutableLiveData<ArrayList<Poker_Result>>();
        buscarDadosCall();
        pokeLiveDatas.setValue(pokerList);
    }

    return  pokeLiveDatas;
}

private void buscarDadosCall(){
    Call<PokerModel> call = API_Cliente_Retrof.acesso().create(Acesse_Servico.class).getPokerModel();
    call.enqueue(new Callback<PokerModel>() {
        @Override
        public void onResponse(Call<PokerModel> call, Response<PokerModel> response) {
            if(response.isSuccessful()){
                pokerList.addAll(response.body().getResults());
            }
        }

        @Override
        public void onFailure(Call<PokerModel> call, Throwable t) {

        }
    });

}


}
