package com.example.mypokerteste.Utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mypokerteste.Model.Interface.OnClick;
import com.example.mypokerteste.Model.Poker_Result;
import com.example.mypokerteste.R;
import java.util.ArrayList;


public class   ListAdapter_PokerModel extends RecyclerView.Adapter<ListAdapter_PokerModel.ViewHolder> {
    Context context;
    ArrayList<Poker_Result> listaModel;
    OnClick onClick;

    public ListAdapter_PokerModel(Context context, ArrayList<Poker_Result> listaModel,OnClick onClick){

        this.context = context;
        this.listaModel = listaModel;
        this.onClick = onClick;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.nomePoker.setText(listaModel.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return listaModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomePoker;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomePoker = itemView.findViewById(R.id.textView_Item);

            itemView.setOnClickListener(v -> onClick.OnClickListner(listaModel.get(ViewHolder.this.getAdapterPosition())));

        }
    }
}
