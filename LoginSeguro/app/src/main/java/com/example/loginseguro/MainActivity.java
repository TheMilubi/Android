package com.example.loginseguro;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login;
    EditText passwd, usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.login);
        passwd = findViewById(R.id.passwd);
        usuario = findViewById(R.id.usuario);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u, p;
                u = usuario.getText().toString();
                p = passwd.getText().toString();
                if (u.equals("usuario") && p.equals("usuario")){
                    setContentView(R.layout.content_usuario);
                }
                else if(u.equals("admin") && p.equals("admin")){
                    setContentView(R.layout.content_admin);
                }
                else{
                    Toast t = Toast.makeText(getApplicationContext(),"Usuario no válido",Toast.LENGTH_SHORT);
                    t.show();
                }

            }
        });
    }

}
