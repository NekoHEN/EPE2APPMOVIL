package com.example.epe2appmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Home_act extends AppCompatActivity {
         private VideoView video1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        video1 = findViewById(R.id.video1);

        video1.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video));

        MediaController mc= new MediaController(this);
        video1.setMediaController(mc);
        mc.setAnchorView(video1);
        video1.start();
    }

    public void reserva(View view)
    {
        Intent i = new Intent(this, Gestor_reserva_act.class);
        startActivity(i);
    }



}