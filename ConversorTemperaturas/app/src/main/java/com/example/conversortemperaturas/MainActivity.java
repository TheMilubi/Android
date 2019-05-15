package com.example.conversortemperaturas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText cent, far;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final TextWatcher tw1 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                float c = cent.getText().toString().equals("")||cent.getText().toString().equals("-")? 0 : Float.valueOf(cent.getText().toString());

                float f = 0;
                f = c * 9/5 + 32;
                far.setText(String.valueOf(f));
            }
        };
        final TextWatcher tw2 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                float f = far.getText().toString().equals("")||far.getText().toString().equals("-")? 0 : Float.valueOf(far.getText().toString());
                float c = 0;
                c = (f - 32)*5/9;
                cent.setText(String.valueOf(c));
            }
        };
        setContentView(R.layout.activity_main);
        cent = findViewById(R.id.centigrados);
        far = findViewById(R.id.farenheit);
        cent.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    cent.setText("");
                    cent.addTextChangedListener(tw1);
                }
                else {
                    cent.removeTextChangedListener(tw1);
                    if (cent.getText().toString().equals("")){
                        cent.setText("0");
                    }
                }
            }
        });
        far.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    far.setText("");
                    far.addTextChangedListener(tw2);
                }
                else {
                    far.removeTextChangedListener(tw2);
                    if (far.getText().toString().equals("")){
                        far.setText("0");
                    }
                }
            }
        });

    }
}
