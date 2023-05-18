package com.example.epe2appmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Gestor_reserva_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] images = {R.drawable.juego1,R.drawable.juego2,R.drawable.juego3};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestor_reserva);
    }

    public void flipImage(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);
        vf.setFlipInterval(3000);
        vf.setAutoStart(true);

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setInAnimation(this, android.R.anim.slide_out_right);
    }
}