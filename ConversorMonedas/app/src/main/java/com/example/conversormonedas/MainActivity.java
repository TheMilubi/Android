package com.example.conversormonedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioGroup de, a;
    EditText et;
    TextView tv;
    Dinero d;
    double cantidad;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        de = findViewById(R.id.de);
        a = findViewById(R.id.a);
        et = findViewById(R.id.editText);
        tv = findViewById(R.id.textView4);
        de.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int valor = Integer.valueOf((et.getText().toString().equals(""))?"0":et.getText().toString());
                switch (checkedId){

                    case R.id.deeuro:{
                        d = new Dinero(tipoMoneda.EURO,valor);
                        s = Dinero.buscaMoneda(tipoMoneda.EURO).getSimbolo() + " = ";
                        tv.setText(s);
                        int cid = a.getCheckedRadioButtonId();
                        cambio(d, s);
                    }break;
                    case R.id.dedolar:{
                        d = new Dinero(tipoMoneda.DOLAR,valor);
                        s = Dinero.buscaMoneda(tipoMoneda.DOLAR).getSimbolo() + " = ";
                        tv.setText(s);
                        int cid = a.getCheckedRadioButtonId();
                        cambio(d, s);
                    }break;
                    case R.id.deyen:{
                        d = new Dinero(tipoMoneda.YEN,valor);
                        s = Dinero.buscaMoneda(tipoMoneda.YEN).getSimbolo() + " = ";
                        tv.setText(s);
                        int cid = a.getCheckedRadioButtonId();
                        cambio(d, s);
                    }

                }
            }
        });
        a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                crear(d, s);
            }
        });
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                crear(d,s);
            }
        });


    }
    public void crear(Dinero d, String s){
        int valor = Integer.valueOf((et.getText().toString().equals(""))?"0":et.getText().toString());
        switch (de.getCheckedRadioButtonId()){

            case R.id.deeuro:{
                d = new Dinero(tipoMoneda.EURO,valor);
                s = Dinero.buscaMoneda(tipoMoneda.EURO).getSimbolo() + " = ";
                tv.setText(s);
                int cid = a.getCheckedRadioButtonId();
                cambio(d, s);
            }break;
            case R.id.dedolar:{
                d = new Dinero(tipoMoneda.DOLAR,valor);
                s = Dinero.buscaMoneda(tipoMoneda.DOLAR).getSimbolo() + " = ";
                tv.setText(s);
                int cid = a.getCheckedRadioButtonId();
                cambio(d, s);
            }break;
            case R.id.deyen:{
                d = new Dinero(tipoMoneda.YEN,valor);
                s = Dinero.buscaMoneda(tipoMoneda.YEN).getSimbolo() + " = ";
                tv.setText(s);
                int cid = a.getCheckedRadioButtonId();
                cambio(d, s);
            }break;

        }
    }
    public void cambio(Dinero d, String s){
        Dinero res;
        switch (a.getCheckedRadioButtonId()){
            case R.id.aeuro:{
                res = d.convierteEn(tipoMoneda.EURO);
                s = s + res.toString();
                tv.setText(s);
            }break;
            case R.id.adolar:{
                res = d.convierteEn(tipoMoneda.DOLAR);
                s = s + res.toString();
                tv.setText(s);
            }break;
            case R.id.ayen:{
                res = d.convierteEn(tipoMoneda.YEN);
                s = s + res.toString();
                tv.setText(s);
            }break;
        }
    }
}
