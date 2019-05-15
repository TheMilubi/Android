package com.example.conversorcentimetrospulgadas;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    protected double pAcm = 2.54;
    EditText et1, et2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.editText);
        et2 = findViewById(R.id.editText2);
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

    }
    protected void aPulgadas(View v){
        EditText et = null, et2 = null;
        try {
            et = findViewById(R.id.editText);
            et2 = findViewById(R.id.editText2);
            double centimetros = Double.valueOf(et.getText().toString());
            double pulgadas = centimetros / pAcm;
            et2.setText(String.format(Locale.FRENCH,"%.2f",pulgadas));
            hideKeyboard();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            et.setText("0");
            et2.setText("0");
        }
    }
    protected void aCentimetros(View v){
        EditText et = null, et2 = null;
        try {
            et = findViewById(R.id.editText);
            et2 = findViewById(R.id.editText2);
            double pulgadas = Double.valueOf(et2.getText().toString());
            double centimetros = pulgadas * pAcm;
            et.setText(String.format(Locale.FRENCH,"%.2f",centimetros));
            hideKeyboard();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            et.setText("0");
            et2.setText("0");
        }
    }
    protected void aNada(View v){
        EditText et = (EditText) v;
        et.setText("");
    }

    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = this.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(this);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
