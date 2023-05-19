package com.example.epe2appmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void informacion(View view)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }

    public void Valoracion(View view)
    {
        Intent i = new Intent(this, Valoracion_act.class);
        startActivity(i);
    }

    public void reserva(View view)
    {
        Intent i = new Intent(this, Gestor_reserva_act.class);
        startActivity(i);
    }

}