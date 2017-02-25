package com.example.cesar.jogodobicho;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cesar.jogodobicho.R;
import com.example.cesar.jogodobicho.activities.MainActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class PegaNumeros extends DialogFragment implements View.OnClickListener {

    private TextView mTextview;
    private boolean isTitular;

    //private TextView lbl01;
    private TextView lbl01;
    private TextView lbl02;
    private TextView lbl03;
    private TextView lbl04;
    private TextView lbl05;
    private TextView lbl06;
    private TextView lbl07;
    private TextView lbl08;
    private TextView lbl09;
    private TextView lbl10;
    private TextView lbl11;
    private TextView lbl12;
    private TextView lbl13;
    private TextView lbl14;
    private TextView lbl15;
    private TextView lbl16;
    private TextView lbl17;
    private TextView lbl18;
    private TextView lbl19;
    private TextView lbl20;
    private TextView lbl21;
    private TextView lbl22;
    private TextView lbl23;
    private TextView lbl24;
    private TextView lbl25;

    private Button btnOK;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setStyle(android.app.DialogFragment.STYLE_NO_TITLE, R.style.MeuDialog)
    }

    @Override
    public void onClick(View view) {
        TextView numSelecionardo = (TextView) view;

        if(isTitular && MainActivity.LISTA_TITULARES.size() < 10){

            if (MainActivity.LISTA_TITULARES.contains(Integer.parseInt(numSelecionardo.getText().toString()))){

                int index = MainActivity.LISTA_TITULARES.indexOf(Integer.parseInt(numSelecionardo.getText().toString()));

                MainActivity.LISTA_TITULARES.remove(index);
                view.setBackgroundResource(0);
                ((TextView) view).setTextColor(Color.parseColor("#e5e5e5"));
            }
            else{
                MainActivity.LISTA_TITULARES.add(Integer.parseInt(numSelecionardo.getText().toString()));
                view.setBackgroundResource(R.drawable.circle_text_borda);
                ((TextView) view).setTextColor(getResources().getColor(R.color.colorPrimary));
            }


        }
        else if (!isTitular && MainActivity.LISTA_RUINS.size() < 15){
            if(MainActivity.LISTA_RUINS.contains(Integer.parseInt(numSelecionardo.getText().toString()))){
                int index = MainActivity.LISTA_RUINS.indexOf(Integer.parseInt(numSelecionardo.getText().toString()));

                MainActivity.LISTA_RUINS.remove(index);
                view.setBackgroundResource(0);
                ((TextView) view).setTextColor(Color.parseColor("#e5e5e5"));
            }
            else {
                MainActivity.LISTA_RUINS.add(Integer.parseInt(numSelecionardo.getText().toString()));
                view.setBackgroundResource(R.drawable.circle_text_borda);
                ((TextView) view).setTextColor(getResources().getColor(R.color.colorPrimary));
            }
        }


        switch (view.getId()) {
            case R.id.lbl_01:
                Log.e("Teste", "01");
                break;
            case R.id.lbl_02:
                Log.e("Teste", "02");
                break;
            case R.id.lbl_03:
                Log.e("Teste", "03");
                break;
            case R.id.lbl_04:
                Log.e("Teste", "04");
                break;
            case R.id.lbl_05:
                Log.e("Teste", "05");
                break;
            case R.id.lbl_06:
                Log.e("Teste", "06");
                break;
            case R.id.lbl_07:
                Log.e("Teste", "07");
                break;
            case R.id.lbl_08:
                Log.e("Teste", "08");
                break;
            case R.id.lbl_09:
                Log.e("Teste", "09");
                break;
            case R.id.lbl_10:
                Log.e("Teste", "10");
                break;
            case R.id.lbl_11:
                Log.e("Teste", "11");
                break;
            case R.id.lbl_12:
                Log.e("Teste", "12");
                break;
            case R.id.lbl_13:
                Log.e("Teste", "13");
                break;
            case R.id.lbl_14:
                Log.e("Teste", "14");
                break;
            case R.id.lbl_15:
                Log.e("Teste", "15");
                break;
            case R.id.lbl_16:
                Log.e("Teste", "16");
                break;
            case R.id.lbl_17:
                Log.e("Teste", "17");
                break;
            case R.id.lbl_18:
                Log.e("Teste", "18");
                break;
            case R.id.lbl_19:
                Log.e("Teste", "19");
                break;
            case R.id.lbl_20:
                Log.e("Teste", "20");
                break;
            case R.id.lbl_21:
                Log.e("Teste", "21");
                break;
            case R.id.lbl_22:
                Log.e("Teste", "22");
                break;
            case R.id.lbl_23:
                Log.e("Teste", "23");
                break;
            case R.id.lbl_24:
                Log.e("Teste", "24");
                break;
            case R.id.lbl_25:
                Log.e("Teste", "25");
                break;


        }
    }

    public interface UserNameListener {
        void onFinishUserDialog(String user);
    }

    // Empty constructor required for DialogFragment
    public PegaNumeros() {

    }

    public boolean isTitular() {
        return isTitular;
    }

    public void setIsTitular(boolean titular) {
        isTitular = titular;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pega_titulares, container);
//        getDialog().getWindow().setSoftInputMode(
//                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        //getDialog().setTitle("Selecione os números");

        lbl01 = (TextView) view.findViewById(R.id.lbl_01);
        lbl01.setOnClickListener(this);

        lbl02 = (TextView) view.findViewById(R.id.lbl_02);
        lbl02.setOnClickListener(this);

        lbl03 = (TextView) view.findViewById(R.id.lbl_03);
        lbl03.setOnClickListener(this);

        lbl04 = (TextView) view.findViewById(R.id.lbl_04);
        lbl04.setOnClickListener(this);

        lbl05 = (TextView) view.findViewById(R.id.lbl_05);
        lbl05.setOnClickListener(this);

        lbl06 = (TextView) view.findViewById(R.id.lbl_06);
        lbl06.setOnClickListener(this);

        lbl07 = (TextView) view.findViewById(R.id.lbl_07);
        lbl07.setOnClickListener(this);

        lbl08 = (TextView) view.findViewById(R.id.lbl_08);
        lbl08.setOnClickListener(this);

        lbl09 = (TextView) view.findViewById(R.id.lbl_09);
        lbl09.setOnClickListener(this);

        lbl10 = (TextView) view.findViewById(R.id.lbl_10);
        lbl10.setOnClickListener(this);

        lbl11 = (TextView) view.findViewById(R.id.lbl_11);
        lbl11.setOnClickListener(this);

        lbl12 = (TextView) view.findViewById(R.id.lbl_12);
        lbl12.setOnClickListener(this);

        lbl13 = (TextView) view.findViewById(R.id.lbl_13);
        lbl13.setOnClickListener(this);

        lbl14 = (TextView) view.findViewById(R.id.lbl_14);
        lbl14.setOnClickListener(this);

        lbl15 = (TextView) view.findViewById(R.id.lbl_15);
        lbl15.setOnClickListener(this);

        lbl16 = (TextView) view.findViewById(R.id.lbl_16);
        lbl16.setOnClickListener(this);

        lbl17 = (TextView) view.findViewById(R.id.lbl_17);
        lbl17.setOnClickListener(this);

        lbl18 = (TextView) view.findViewById(R.id.lbl_18);
        lbl18.setOnClickListener(this);

        lbl19 = (TextView) view.findViewById(R.id.lbl_19);
        lbl19.setOnClickListener(this);

        lbl20 = (TextView) view.findViewById(R.id.lbl_20);
        lbl20.setOnClickListener(this);

        lbl21 = (TextView) view.findViewById(R.id.lbl_21);
        lbl21.setOnClickListener(this);

        lbl22 = (TextView) view.findViewById(R.id.lbl_22);
        lbl22.setOnClickListener(this);

        lbl23 = (TextView) view.findViewById(R.id.lbl_23);
        lbl23.setOnClickListener(this);

        lbl24 = (TextView) view.findViewById(R.id.lbl_24);
        lbl24.setOnClickListener(this);

        lbl25 = (TextView) view.findViewById(R.id.lbl_25);
        lbl25.setOnClickListener(this);

        btnOK = (Button)view.findViewById(R.id.btnOK);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Botao", "Clicou");
                dismiss();
            }
        });
        return view;
    }



    public void clickFinish(Context context) {
    }
}
