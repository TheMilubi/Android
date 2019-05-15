package com.example.estadisticastexto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv1,tv2,tv3,tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.editText);
        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        tv4 = findViewById(R.id.textView4);

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String string = et.getText().toString();
                tv1.setText("Letras: "+contarLetras(string));
                tv2.setText("Vocales: "+contarVocales(string));
                tv3.setText("Consonantes: "+contarConsonantes(string));
                tv4.setText("Palabras: "+contarPalabras(string));
            }
        });
    }
    public int contarLetras(String s){
        int cont = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))){
                cont++;
            }
        }
        return cont;
    }
    public int contarVocales(String s){
        int cont = 0;
        for (int i = 0; i < s.length(); i++) {
            if ("aeoiuáéíóúü".contains(s.substring(i,i+1).toLowerCase())){
                cont++;
            }
        }
        return cont;
    }
    public int contarConsonantes(String s){
        int cont = 0;
        for (int i = 0; i < s.length(); i++) {
            if ("bcdfghjklmnñpqrstvwxyz".contains(s.substring(i,i+1).toLowerCase())){
                cont++;
            }
        }
        return cont;
    }
    public int contarPalabras(String s){
        int cont = 0;
        if (s.equals("")){
            cont = 0;
        }else {
            cont = s.split(" ").length;
        }

        return cont;
    }
}
