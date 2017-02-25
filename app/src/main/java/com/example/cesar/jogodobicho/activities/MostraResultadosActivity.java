package com.example.cesar.jogodobicho.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.cesar.jogodobicho.R;
import com.example.cesar.jogodobicho.RecyclerAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MostraResultadosActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerAdapter mAdapter;
    List<String> numerosSortear = new ArrayList<String>();//= {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
//            "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_resultados);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // ou
        //setActionBar(tlb);

        // Apos isso, podera configurar sua Action Bar normalmente
        // Por exemplo:
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        Intent it = getIntent();
        Bundle params = it.getExtras();

        List<String> titulares = params.getStringArrayList("titulares");
        List<String> ruins = params.getStringArrayList("ruins");
        Collections.sort(titulares);
        Collections.sort(ruins);

        String comparador;
        for(int i = 1; i < 26; i++){

            if (i < 10){
                comparador = 0 + "" + i;
            }
            else{
                comparador = "" + i;
            }
//            if (titulares.size() > i) {
//                if (numerosBichos[i].equals(titulares.get(i))) {
//                    Log.e("teste", numerosBichos[i]);
//                }
//            }
            if(titulares.contains(comparador) || ruins.contains(comparador)){
                continue;
            }

            numerosSortear.add(comparador);

        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        RecyclerAdapter adapter = new RecyclerAdapter(titulares, numerosSortear);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed(){
        finish();
        MainActivity.LISTA_TITULARES.clear();
        MainActivity.LISTA_RUINS.clear();
    }

}
