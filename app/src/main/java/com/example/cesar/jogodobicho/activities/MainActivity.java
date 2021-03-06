package com.example.cesar.jogodobicho.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cesar.jogodobicho.BottomSheetModalFragment;
import com.example.cesar.jogodobicho.PegaNumeros;
import com.example.cesar.jogodobicho.R;
import com.example.cesar.jogodobicho.RecyclerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PegaNumeros.UserNameListener {

    private TextView definirTitulares;
    private TextView qtdeJogos;

    private RadioGroup rgJogos;

    private String jogo_selecionado = "DEZ_POR_QUATRO";

    public static ArrayList<String> LISTA_TITULARES = new ArrayList<String>();
    public static ArrayList<String> LISTA_RUINS = new ArrayList<String>();

    BottomSheetDialogFragment bsdFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        definirTitulares = (TextView) findViewById(R.id.txtDefinirTitulares);
        qtdeJogos = (TextView) findViewById(R.id.txtQtdeJogos);
        rgJogos = (RadioGroup) findViewById(R.id.rgJogos);

        rgJogos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                {
                    case R.id.rbDezPorQuatro:
                        jogo_selecionado = "DEZ_POR_QUATRO";
                        break;
                    case R.id.rbSetePorQuatro:
                        jogo_selecionado = "SETE_POR_QUATRO";
                        break;
                    case R.id.rbDozePorCinco:
                        jogo_selecionado = "DOZE_POR_CINCO";
                        break;
                    case R.id.rbQuinzePorCinco:
                        jogo_selecionado = "QUINZE_POR_CINCO";
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Deu merda!!! Chama o César", Toast.LENGTH_SHORT).show();;
                }
            }
        });
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
        } else if (view.getId() == R.id.item_modal_ruins) {
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
        it.putStringArrayListExtra("titulares", LISTA_TITULARES);
        it.putStringArrayListExtra("ruins", LISTA_RUINS);
        it.putExtra("jogo_selecionado", jogo_selecionado);
        startActivity(it);

    }

    public void definirQtdeJogos(View view) {
        final NumberPicker picker;

        picker = new NumberPicker(MainActivity.this);
        picker.setMinValue(1);
        picker.setMaxValue(15);

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Quantidade de Jogos")
                .setView(picker)
                .setNegativeButton("Cancelar", null)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        qtdeJogos.setText(picker.getValue() + " JOGOS");
                        RecyclerAdapter.qtdeJogos = picker.getValue();
                    }
                })
                .show();
    }
}
