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
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Cesar on 09/02/2017.
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private String teste;
    private List<Integer> titulares = new ArrayList<Integer>();
    private List<Integer> numerosSortear = new ArrayList<Integer>();

    int num1, num2, num3, num4, num5;


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView[] txtNumeros = new TextView[10];//{} tv1, tv2, tv3, tv4 , tv5, tv6, tv7, tv8, tv9, tv10,
        TextView tvAvatar;
        ImageView imageView;
        public List<Integer> lista;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
//
            txtNumeros[0] = (TextView) itemView.findViewById(R.id.txt1);
            txtNumeros[1] = (TextView) itemView.findViewById(R.id.txt2);
            txtNumeros[2] = (TextView) itemView.findViewById(R.id.txt3);
            txtNumeros[3] = (TextView) itemView.findViewById(R.id.txt4);
            txtNumeros[4] = (TextView) itemView.findViewById(R.id.txt5);
            txtNumeros[5] = (TextView) itemView.findViewById(R.id.txt6);
            txtNumeros[6] = (TextView) itemView.findViewById(R.id.txt7);
            txtNumeros[7] = (TextView) itemView.findViewById(R.id.txt8);
            txtNumeros[8] = (TextView) itemView.findViewById(R.id.txt9);
            txtNumeros[9] = (TextView) itemView.findViewById(R.id.txt10);




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

        geraNumeros();
        int contador = 0;
        for (int i = 0; i < titulares.size(); i++){
            holder.txtNumeros[i].setText(titulares.get(i).toString());
            contador ++;
        }

        for (int i = contador, j = 0; i < 10; i++, j++){
            holder.txtNumeros[i].setText(numerosSortear.get(j).toString());
        }
       // holder.tv8.setText(titulares.get(2).toString());
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    public void geraNumeros() {

        Collections.shuffle(numerosSortear);

    }

    public void embaralha() {
        //Collections.shuffle(lista2);

        Random gerador = new Random();
        num1 = gerador.nextInt(16);
        num2 = gerador.nextInt(16);
        num3 = gerador.nextInt(16);
        num4 = gerador.nextInt(16);
        num5 = gerador.nextInt(16);

        if (num1 == num2 || num1 == num3 || num1 == num4 || num1 == num5 ||
                num2 == num3 || num2 == num4 || num2 == num5 || num3 == num4 ||
                num3 == num5 || num4 == num5) {

            embaralha();
        }


    }



}
