package com.example.contadorsimple;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    ImageButton ib;
    int contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        ib = findViewById(R.id.boton);
        contador = getPreferences(MODE_PRIVATE).getInt("contador",0);
        tv.setText(String.valueOf(contador));
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                tv.setText(String.valueOf(contador));
                SharedPreferences.Editor e = getPreferences(MODE_PRIVATE).edit();
                e.putInt("contador",contador);
                e.apply();
            }
        });
        ib.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                contador = 0;
                tv.setText(String.valueOf(contador));
                SharedPreferences.Editor e = getPreferences(MODE_PRIVATE).edit();
                e.putInt("contador",contador);
                e.apply();
                return true;
            }
        });
    }

}
