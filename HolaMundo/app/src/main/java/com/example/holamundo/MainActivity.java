package com.example.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    boolean hayTexto = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    protected void buttonClick(View v){
        TextView texto = findViewById(R.id.textView);
        if (hayTexto){
            texto.setText("");
            hayTexto = false;
        }
        else {
            texto.setText("Hola Mundo");
            hayTexto = true;
        }

    }

}
