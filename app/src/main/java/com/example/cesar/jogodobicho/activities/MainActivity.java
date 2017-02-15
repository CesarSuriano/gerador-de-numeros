package com.example.cesar.jogodobicho.activities;

import android.content.Intent;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cesar.jogodobicho.BottomSheetModalFragment;
import com.example.cesar.jogodobicho.PegaNumeros;
import com.example.cesar.jogodobicho.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PegaNumeros.UserNameListener {

    private TextView definirTitulares;

    public static ArrayList<Integer> LISTA_TITULARES = new ArrayList<Integer>();

    BottomSheetDialogFragment bsdFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        definirTitulares = (TextView) findViewById(R.id.txtDefinirTitulares);
    }


    public void mostraModal(View view) {

        bsdFragment =
                BottomSheetModalFragment.newInstance();

        bsdFragment.show(
                MainActivity.this.getSupportFragmentManager(), "BSDialog");

    }

    public void definirNumeros(View view) {
        FragmentManager fm = getSupportFragmentManager();
        PegaNumeros dialogFragment = new PegaNumeros();
        if (view.getId() == R.id.item_modal_titulares) {
            dialogFragment.setIsTitular(true);
        }
        else if (view.getId() == R.id.item_modal_ruins) {
            dialogFragment.setIsTitular(false);
        }

        dialogFragment.show(fm, "Sample Fragment");
        bsdFragment.dismiss();
    }

    @Override
    public void onFinishUserDialog(String user) {
        Toast.makeText(this, "Hello, " + user, Toast.LENGTH_SHORT).show();
    }

    public void gerarNumeros(View view) {
        String str = "nada";

        Intent it = new Intent(MainActivity.this, MostraResultadosActivity.class);
//        Bundle params = new Bundle();
//        params.putParcelableArrayList("num", LISTA_TITULARES);
        it.putIntegerArrayListExtra("titulares", LISTA_TITULARES);
        startActivity(it);

    }
}
