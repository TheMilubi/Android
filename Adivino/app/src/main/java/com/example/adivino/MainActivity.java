package com.example.adivino;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView num;
    Button min, max, igual;
    int numero;
    int minimo;
    int maximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = findViewById(R.id.num);
        max = findViewById(R.id.mayor);
        min = findViewById(R.id.menor);
        igual = findViewById(R.id.igual);
        max.setEnabled(false);
        min.setEnabled(false);
        igual.setEnabled(false);
    }

    public void mayor(View v) {
        minimo = numero;
        numero = numero + maximo;
        numero = numero / 2;
        num.setText(""+numero);
    }

    public void menor(View v){
        maximo = numero;
        numero = numero + minimo;
        numero = numero / 2;
        num.setText(""+numero);
    }

    public void igual(View v){
        Button b = findViewById(R.id.start);
        b.setEnabled(true);
        min.setEnabled(false);
        max.setEnabled(false);
        igual.setEnabled(false);
    }

    public void empezar(View v){
        v.setEnabled(false);
        numero = 50;
        minimo = 1;
        maximo = 100;
        num.setText(""+numero);
        min.setEnabled(true);
        max.setEnabled(true);
        igual.setEnabled(true);
    }

}
