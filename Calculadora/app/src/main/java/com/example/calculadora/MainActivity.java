package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2, resultado;
    TextView operacion;
    Button btnsuma, btnresta, btnmult, btndiv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operacion = findViewById(R.id.operacion);
        et1 = findViewById(R.id.op1);
        et2 = findViewById(R.id.op2);
        resultado = findViewById(R.id.result);
        btnsuma = findViewById(R.id.btnplus);
        btnresta = findViewById(R.id.btnminus);
        btnmult = findViewById(R.id.btnmult);
        btndiv = findViewById(R.id.btndiv);
        et1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                EditText et = (EditText)v;
                if(hasFocus)
                {
                    et.setText("");
                }
            }
        });
        et2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                EditText et = (EditText)v;
                if(hasFocus)
                {
                    et.setText("");
                }
            }
        });
        btnsuma.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                comprobar(v,0,0);
                sumar(v);
            }
        });
        btnresta.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                comprobar(v,0,0);
                restar(v);
            }
        });
        btnmult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                comprobar(v,0,0);
                multiplicar(v);
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                comprobar(v,0,1);
                dividir(v);
            }
        });
    }
    public void sumar(View v){
        double op1,op2, result;
        op1 = Double.valueOf(et1.getText().toString());
        op2 = Double.valueOf(et2.getText().toString());
        result = op1 + op2;
        operacion.setText("+");
        resultado.setText(""+result);
    }
    public void restar(View v){
        double op1,op2, result;
        op1 = Double.valueOf(et1.getText().toString());
        op2 = Double.valueOf(et2.getText().toString());
        result = op1 - op2;
        operacion.setText("-");
        resultado.setText(""+result);
    }
    public void multiplicar(View v){
        double op1,op2, result;
        op1 = Double.valueOf(et1.getText().toString());
        op2 = Double.valueOf(et2.getText().toString());
        result = op1 * op2;
        operacion.setText("x");
        resultado.setText(""+result);
    }
    public void dividir(View v){
        double op1,op2, result;
        op1 = Double.valueOf(et1.getText().toString());
        op2 = Double.valueOf(et2.getText().toString());
        result = op1 / op2;
        operacion.setText("/");
        resultado.setText(""+result);
    }
    public void comprobar(View v, int op1, int op2){
        if(et1.getText().toString().equals("")){
            et1.setText(""+op1);
        }
        if (et2.getText().toString().equals("")){
            et2.setText(""+op2);
        }
        if(v.equals(findViewById(R.id.btndiv))){
            if(et2.getText().toString().equals("0")){
                et2.setText("1");
            }
        }
    }

}
