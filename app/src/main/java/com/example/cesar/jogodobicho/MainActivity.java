package com.example.cesar.jogodobicho;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PegaTitulares.UserNameListener {

    private TextView definirTitulares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        definirTitulares = (TextView) findViewById(R.id.txtDefinirTitulares);
    }


    public void definirTitulares(View view) {
        FragmentManager fm = getSupportFragmentManager();
        PegaTitulares dialogFragment = new PegaTitulares ();
        dialogFragment.show(fm, "Sample Fragment");

    }

    @Override
    public void onFinishUserDialog(String user) {
        Toast.makeText(this, "Hello, " + user, Toast.LENGTH_SHORT).show();
    }
}
