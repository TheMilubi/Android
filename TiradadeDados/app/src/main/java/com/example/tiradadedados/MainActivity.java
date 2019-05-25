package com.example.tiradadedados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    NumberPicker np1, np2;
    Button b;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] s = {"4", "6", "8", "10", "12", "20"};
        tv = findViewById(R.id.textView);
        np1 = findViewById(R.id.numberPicker);
        np2 = findViewById(R.id.numberPicker2);
        np1.setMinValue(1);
        np1.setMaxValue(10);
        np1.setWrapSelectorWheel(false);
        np2.setMinValue(1);
        np2.setDisplayedValues(s);
        np2.setMaxValue(s.length);
        np2.setWrapSelectorWheel(false);
        b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dado, dado2, tirada, total = 0;
                String tiradas = "Tiradas: ";
                Random r = new Random();
                dado = np1.getValue();
                switch (np2.getValue()){
                    case 1:
                        dado2 = 4;
                        break;
                    case 2:
                        dado2 = 6;
                        break;
                    case 3:
                        dado2 = 8;
                        break;
                    case 4:
                        dado2 = 10;
                        break;
                    case 5:
                        dado2 = 12;
                        break;
                    case 6:
                        dado2 = 20;
                        break;
                        default: dado2 = 6;
                }
                for (int i = 1; i <= dado; i++) {
                    tirada = r.nextInt(dado2)+1;
                    tiradas = tiradas + tirada + ((i<dado)?", ":"\n");
                    total += tirada;
                }
                tv.setText(tiradas+"Suma: "+total);
            }
        });
    }
}
