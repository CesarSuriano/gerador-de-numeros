package com.example.cesar.jogodobicho;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Cesar on 09/02/2017.
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private String teste;

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView tv6, tv7, tv8, tv9, tv10, tvAvatar;
        ImageView imageView;
        public List<Integer> lista;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
//
//            tv6 = (TextView) itemView.findViewById(R.id.txt6);
//            tv7 = (TextView) itemView.findViewById(R.id.txt7);
//            tv8 = (TextView) itemView.findViewById(R.id.txt8);
//            tv9 = (TextView) itemView.findViewById(R.id.txt9);
//            tv10 = (TextView) itemView.findViewById(R.id.txt10);




            tvAvatar = (TextView) itemView.findViewById(R.id.list_avatar);
            tvAvatar.setText("01");
        }
    }

    public RecyclerAdapter (String teste){
        this.teste = teste;
    }

    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_resultado, parent, false);
        return new RecyclerAdapter.RecyclerViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.RecyclerViewHolder holder, int position) {
        holder.tvAvatar.setText(teste);
    }

    @Override
    public int getItemCount() {
        return 2;
    }



}
