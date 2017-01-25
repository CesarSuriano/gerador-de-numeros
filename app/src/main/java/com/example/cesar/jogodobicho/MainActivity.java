package com.example.cesar.jogodobicho;

import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        TextView txt = (TextView) findViewById(R.id.txt);
        txt.setBackgroundResource(R.drawable.circle_text);
    }

    public void definirTitulares(View view) {
        FragmentManager fm = getSupportFragmentManager();
        PegaTitulares pegaTitulares = PegaTitulares.newInstance("Some Title");
        pegaTitulares.show(fm, "fragment_edit_name");

    }
}
