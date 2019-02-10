package com.example.cesar.jogodobicho;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Cesar on 09/02/2017.
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private String teste;
    public static int qtdeJogos = 10;
    private List<String> numerosTitulares = new ArrayList<String>();
    private List<String> numerosSortear = new ArrayList<String>();
    private int qtdeNumeros;
    //private List[] numerosFinais = new ArrayList[10];
    //private List<Integer> numerosFinais = new ArrayList<Integer>();

    private ArrayList<String>[][] numerosFinais = new ArrayList[15][15];

    int num1, num2, num3, num4, num5;


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView[] txtNumeros = new TextView[15];//{} tv1, tv2, tv3, tv4 , tv5, tv6, tv7, tv8, tv9, tv10,
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
            txtNumeros[10] = (TextView) itemView.findViewById(R.id.txt11);
            txtNumeros[11] = (TextView) itemView.findViewById(R.id.txt12);
            txtNumeros[12] = (TextView) itemView.findViewById(R.id.txt13);
            txtNumeros[13] = (TextView) itemView.findViewById(R.id.txt14);
            txtNumeros[14] = (TextView) itemView.findViewById(R.id.txt15);




            tvAvatar = (TextView) itemView.findViewById(R.id.list_avatar);

        }
    }

    public RecyclerAdapter (List<String> titulares, List<String> numerosSortear, String jogoSelecionado){

        switch (jogoSelecionado){
            case "DEZ_POR_QUATRO":
                this.qtdeNumeros = 10;
                break;
            case "SETE_POR_QUATRO":
                this.qtdeNumeros = 7;
                break;
            case "DOZE_POR_CINCO":
                this.qtdeNumeros = 12;
                break;
            case "QUINZE_POR_CINCO":
                this.qtdeNumeros = 15;
                break;
        }

        this.numerosTitulares = titulares;
        this.numerosSortear = numerosSortear;
        geraNumeros();

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


        for (int i = 0; i < qtdeNumeros; i++) {

                holder.txtNumeros[i].setText(numerosFinais[position][i].toString().replace("[", " ").replace("]", " "));


        }

    }

    @Override
    public int getItemCount() {
        return qtdeJogos;
    }


    public void geraNumeros() {

        //
        Log.i("ta aquii", "ta aquiiii");
        for ( int i = 0; i < 15; i++ ){
            Log.i("no for 1", i + "");
            Collections.shuffle(numerosSortear);
            for (int j = 0; j < numerosTitulares.size(); j++) {
                Log.i("no for 2", j + "");
//                Log.e("o que tem no j:", "" + j);
//                numerosFinais.add(i, Arrays.asList(j));
                numerosFinais[i][j] = new ArrayList<String>();
                numerosFinais[i][j].add(numerosTitulares.get(j));
            }

            for (int f = numerosTitulares.size(); f < 15; f++){
                Log.i("no for 3", f + "");
                numerosFinais[i][f] = new ArrayList<String>();
                numerosFinais[i][f].add(numerosSortear.get(f));
            }
        }
    }

}
