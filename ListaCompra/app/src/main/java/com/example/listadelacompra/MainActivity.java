package com.example.listadelacompra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArticuloAdapter adapter;
    ListView listView;
    ArrayList<Articulo> articulos;
    Button limpiar, add;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Construct the data source
        articulos = new ArrayList<Articulo>();
        // Create the adapter to convert the array to views
        adapter = new ArticuloAdapter(this, articulos);
        // Attach the adapter to a ListView
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        leer();
        //texto
        editText = findViewById(R.id.editText);
        //botones
        add = findViewById(R.id.add);
        limpiar = findViewById(R.id.limpiar);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editText.getText().toString().trim();
                Articulo articulo = new Articulo(nombre);
                adapter.add(articulo);
                editText.setText("");
            }
        });
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < adapter.getCount(); i++) {
                    Articulo articulo = adapter.getItem(i);
                    if (articulo.check){
                        adapter.remove(articulo);
                        i--;
                    }
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        escribir();

    }
    public void leer(){
        try {
            FileInputStream fis = openFileInput("ListaCompra");
            DataInputStream dis = new DataInputStream(fis);
            int items = dis.readInt();
            for (int i = 0; i < items; i++) {
                String nombre = dis.readUTF();
                Articulo articulo = new Articulo(nombre);
                articulo.check = dis.readBoolean();
                adapter.add(articulo);
            }
            dis.close();
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void escribir(){
        try {
            FileOutputStream fos = openFileOutput("ListaCompra",MODE_PRIVATE);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(articulos.size());
            for (int i = 0; i < articulos.size(); i++) {
                dos.writeUTF(articulos.get(i).nombre);
                dos.writeBoolean(articulos.get(i).check);
            }
            dos.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
