package com.example.epe2appmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declaramos los EditText que usaremos
    private EditText etUser;
    private EditText etPass;
    //Creamos a los administradores;
    private Administrador admin = new Administrador("Nicolas","123");
    private Administrador admin2 = new Administrador("Diego","123");
    private Administrador admin3 = new Administrador("Sebastian","123");
    private Administrador admin4 = new Administrador("Patricio","123");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
    }

    public void home(View view)
    {

        //Elementos guardados por id

        String user = etUser.getText().toString();
        String pass = etPass.getText().toString();

        if (user.equals("") || pass.equals("")) {
            Toast.makeText(getBaseContext(), "Campos Vacios", Toast.LENGTH_LONG).show();
        } else {
            if (!user.equals(admin.usuario) && !pass.equals(admin.contrasenha)) {
                Toast.makeText(getBaseContext(), "Error al iniciar sesión", Toast.LENGTH_LONG).show();
            } else {
                if (user.equals(admin2.usuario) || pass.equals(admin2.contrasenha)) {
                    Intent i = new Intent(this, Home_act.class);
                    startActivity(i);
                }else{
                    if (user.equals(admin3.usuario) || pass.equals(admin3)) {
                        Intent i = new Intent(this, Home_act.class);
                        startActivity(i);
                    }else{
                        if (user.equals(admin4.usuario) || pass.equals(admin4.contrasenha)) {
                            Intent i = new Intent(this, Home_act.class);
                            startActivity(i);
                        }
                    }
                }
            }
        }
    }
}
