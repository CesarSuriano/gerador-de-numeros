package com.example.cesar.jogodobicho;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PegaTitulares.UserNameListener {

    private TextView definirTitulares;

    public static List<Integer> LISTA_TITULARES = new ArrayList<Integer>();

    BottomSheetDialogFragment bsdFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        definirTitulares = (TextView) findViewById(R.id.txtDefinirTitulares);
    }




    public void definirTitulares(View view) {

        bsdFragment =
                BottomSheetModalFragment.newInstance();

        bsdFragment.show(
                MainActivity.this.getSupportFragmentManager(), "BSDialog");

    }

    public void definirTitulares2(View view){
        FragmentManager fm = getSupportFragmentManager();
        PegaTitulares dialogFragment = new PegaTitulares ();
        dialogFragment.show(fm, "Sample Fragment");
        bsdFragment.dismiss();
    }

    @Override
    public void onFinishUserDialog(String user) {
        Toast.makeText(this, "Hello, " + user, Toast.LENGTH_SHORT).show();
    }

    public void gerarNumeros(View view) {
        for (Integer i : LISTA_TITULARES) {
            Log.e("Numeros: ", ""+ i);
        }

        startActivity(new Intent(MainActivity.this, MostraResultados.class));

    }
}
