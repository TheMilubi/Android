package com.example.minidiario;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText et;
    String fecha;
    DatePickerDialog date;
    Date d;
    SimpleDateFormat simpleDateFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                fecha = (dayOfMonth>9) ? (""+dayOfMonth+"-") :("0"+dayOfMonth+"-");
                fecha = ((month + 1) > 9) ?(fecha +""+(month+1)):(fecha+"0"+(month+1));
                fecha = fecha + "-" + year;
                button.setText(fecha.replaceAll("-", "/"));
                leer(fecha);

            }
        }, Calendar.getInstance().get(Calendar.YEAR),Calendar.getInstance().get(Calendar.MONTH),Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        button = findViewById(R.id.button);
        et = findViewById(R.id.editText);
        d = Calendar.getInstance().getTime();
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
        fecha = simpleDateFormat.format(d);
        button.setText(fecha.replaceAll("-","/"));
        leer(fecha);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.show();
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
            public void afterTextChanged(Editable s) {
                escribir(fecha);
            }
        });
    }
    void leer(String fecha){
        String s = "";
        try {
            FileInputStream fis = openFileInput(fecha);
            DataInputStream dis = new DataInputStream(fis);
            s = dis.readUTF();
            dis.close();
            fis.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        et.setText(s);
    }
    void escribir(String fecha){
        try {
            FileOutputStream fos = openFileOutput(fecha,MODE_PRIVATE);
            DataOutputStream dos = new DataOutputStream(fos);
            if (et.getText().toString().getBytes().length > 0){
                dos.writeUTF(et.getText().toString());
            }
            dos.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
