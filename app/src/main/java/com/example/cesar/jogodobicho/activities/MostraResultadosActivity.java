package com.example.cesar.jogodobicho.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    List<Integer> numerosSortear = new ArrayList<Integer>();//= {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
//            "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_resultados);
        Intent it = getIntent();
        Bundle params = it.getExtras();

        List<Integer> titulares = params.getIntegerArrayList("titulares");
        List<Integer> ruins = params.getIntegerArrayList("ruins");
        Collections.sort(titulares);
        Collections.sort(ruins);

        Toast.makeText(this, ""+ruins.get(0), Toast.LENGTH_SHORT).show();

        for(int i = 0; i < 25; i++){
//            if (titulares.size() > i) {
//                if (numerosBichos[i].equals(titulares.get(i))) {
//                    Log.e("teste", numerosBichos[i]);
//                }
//            }
            if(titulares.contains(i) || ruins.contains(i)){
                continue;
            }

            numerosSortear.add(i);

        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        RecyclerAdapter adapter = new RecyclerAdapter(titulares, numerosSortear);
        mRecyclerView.setAdapter(adapter);
    }
}
