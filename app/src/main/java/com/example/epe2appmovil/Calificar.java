package com.example.epe2appmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.Spinner;

public class Calificar extends AppCompatActivity {

    private Spinner spOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificar);

        spOpciones = findViewById(R.id.spOpcion);

        String [] opciones = {"Visuales","Organizacion","Colores","Imagenes"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spOpciones.setAdapter(adapter);
    }
    public void subir(View view) {
        Toast.makeText(getBaseContext(), "Gracias por calificarnos", Toast.LENGTH_LONG).show();
    }
}