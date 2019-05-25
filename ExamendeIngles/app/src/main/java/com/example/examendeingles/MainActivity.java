package com.example.examendeingles;

import android.service.autofill.CharSequenceTransformation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner1, spinner2, spinner3;
    ArrayAdapter<String> itemsAdapter1, itemsAdapter2, itemsAdapter3;
    TextView tv;
    ArrayList<String> items1 = new ArrayList<>();
    ArrayList<String> items2 = new ArrayList<>();
    ArrayList<String> items3 = new ArrayList<>();
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView7);
        b = findViewById(R.id.button);
        spinner1 = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        items1.add("is");
        items1.add("are");
        items1.add("has");
        items1.add("have");
        items2.add("in");
        items2.add("on");
        items2.add("between");
        items3.add("go");
        items3.add("goes");
        items3.add("went");
        items3.add("will go");
        itemsAdapter1 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,items1);
        itemsAdapter2 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,items2);
        itemsAdapter3 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,items3);
        //itemsAdapter = ArrayAdapter.createFromResource(this,R.array.respuestas,android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(itemsAdapter1);
        spinner2.setAdapter(itemsAdapter2);
        spinner3.setAdapter(itemsAdapter3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                corregir();
            }
        });

    }
    void corregir(){
        String r1 = "is", r2 = "on", r3 = "went";
        int contador = 0;
        if(spinner1.getSelectedItem().toString().equals(r1)){
            contador++;
        }
        if (spinner2.getSelectedItem().toString().equals(r2)){
            contador++;
        }
        if (spinner3.getSelectedItem().toString().equals(r3)){
            contador++;
        }
        tv.setText("Has acertado " + contador + " de 3 preguntas");
    }
}
