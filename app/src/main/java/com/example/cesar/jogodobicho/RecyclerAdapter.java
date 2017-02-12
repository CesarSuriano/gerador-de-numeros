package com.example.cesar.jogodobicho;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cesar on 09/02/2017.
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private String teste;
    private List<Integer> titulares = new ArrayList<Integer>();
    private List<Integer> numerosSortear = new ArrayList<Integer>();


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView tv1, tv2, tv3, tv4 , tv5, tv6, tv7, tv8, tv9, tv10, tvAvatar;
        ImageView imageView;
        public List<Integer> lista;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
//
            tv1 = (TextView) itemView.findViewById(R.id.txt1);
            tv2 = (TextView) itemView.findViewById(R.id.txt2);
            tv3 = (TextView) itemView.findViewById(R.id.txt3);
            tv4 = (TextView) itemView.findViewById(R.id.txt4);
            tv5 = (TextView) itemView.findViewById(R.id.txt5);
            tv6 = (TextView) itemView.findViewById(R.id.txt6);
            tv7 = (TextView) itemView.findViewById(R.id.txt7);
            tv8 = (TextView) itemView.findViewById(R.id.txt8);
            tv9 = (TextView) itemView.findViewById(R.id.txt9);
            tv10 = (TextView) itemView.findViewById(R.id.txt10);




            tvAvatar = (TextView) itemView.findViewById(R.id.list_avatar);
        }
    }

    public RecyclerAdapter (List<Integer> titulares, List<Integer> numerosSortear){
        this.titulares = titulares;
        this.numerosSortear = numerosSortear;
    }

    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_resultado, parent, false);
        return new RecyclerAdapter.RecyclerViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.RecyclerViewHolder holder, int position) {
        holder.tvAvatar.setText(position + 1 + "");
        holder.tv6.setText(titulares.get(0).toString());
        holder.tv7.setText(titulares.get(1).toString());
       // holder.tv8.setText(titulares.get(2).toString());
    }

    @Override
    public int getItemCount() {
        return 10;
    }



}
