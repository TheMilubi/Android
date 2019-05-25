package com.example.colorpicker;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView color, nr, ng, nb;
    SeekBar rojo, verde, azul;
    int r = 0, v = 0, a = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        color = findViewById(R.id.color);
        rojo = findViewById(R.id.rojo);
        verde = findViewById(R.id.verde);
        azul = findViewById(R.id.azul);
        nr = findViewById(R.id.r);
        ng = findViewById(R.id.g);
        nb = findViewById(R.id.b);
        color.setBackgroundColor(Color.rgb(r,v,a));
        rojo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                r = progress;
                color.setBackgroundColor(Color.rgb(r,v,a));
                nr.setText(""+r);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        verde.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                v = progress;
                color.setBackgroundColor(Color.rgb(r,v,a));
                ng.setText(""+v);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        azul.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                a = progress;
                color.setBackgroundColor(Color.rgb(r,v,a));
                nb.setText(""+a);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
