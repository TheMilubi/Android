package com.example.tecladopin;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);

    }
    public void onClick(View v){
        b = (Button) v;
        String newNum = b.getText().toString();
        String actual = text.getText().toString();
        actual = actual + newNum;
        if(text.getText().toString().length() < 4){
            text.setText(actual);
        }
        if(text.getText().toString().length() == 4){
            comprobar("1234");
        }
    }
    private void comprobar(String codigoCorrecto){
        if (text.getText().toString().equals(codigoCorrecto)){
            text.setTextColor(Color.GREEN);
            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            text.setText("");
                            text.setTextColor(Color.BLACK);
                        }
                    },
                    1000);
        }
        else {
            text.setTextColor(Color.RED);
            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            text.setText("");
                            text.setTextColor(Color.BLACK);
                        }
                    },
                    1000);

        }
    }
}
