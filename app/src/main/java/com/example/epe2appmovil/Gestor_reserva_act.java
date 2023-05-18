package com.example.epe2appmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ViewFlipper;

import database.AdminSQLiteOpenHelper;
import models.reserva;

public class Gestor_reserva_act extends AppCompatActivity {
// codigo slider de imagenes comienzo
    private ViewFlipper vf;
    private int[] images = {R.drawable.juego1,R.drawable.juego2,R.drawable.juego3};



    private EditText tnombre, tid, tjuegos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestor_reserva);

// codigo slider de imagenes comienzo
    vf = findViewById(R.id.slider);

        for(int i=0; i < images.length; i++)
    {
        flipImage(images[i]);
    }



        tnombre = findViewById(R.id.txNombre);
        tid = findViewById(R.id.txid);
        tjuegos = findViewById(R.id.txJuegos);



}
    // codigo slider de imagenes comienzo
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


    public void añadirClientes(View view)// EJEMPLO DE AÑADIR DATOS A LA BASE DE DATOS
    {
        // traer la base de datos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "juegos", null, 1);
        // permisos de escritura para hacer cambios dentro de la base de datos
        SQLiteDatabase db = admin.getWritableDatabase();

        if (!tid.getText().toString().isEmpty())//si el id no esta vacio
        {
            ContentValues registro = new ContentValues();// agrupacion de valores
            // se renplaza los datos de la data base ´por los campos de entrada
            registro.put("cod_cliente", tid.getText().toString());
            registro.put("nombre", tnombre.getText().toString());
            registro.put("juego",tjuegos.getText().toString());

            db.insert("clientes", null, registro);// añadimos
            db.close();// cerramos la database

            Toast.makeText(getBaseContext(), "Se ha gurdado un cliente", Toast.LENGTH_LONG).show();
        }
    }

    public void Consultar(View view)// EJEMPLO DE AÑADIR DATOS A LA BASE DE DATOS
    {
        // traer la base de datos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "juegos", null, 1);
        // permisos de escritura para hacer cambios dentro de la base de datos
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = tid.getText().toString();

        if (!codigo.isEmpty())//si el id no esta vacio
        {
            Cursor fila = db.rawQuery("Select nombre, juego from clientes WHERE cod_cliente= " + codigo, null);

            if (fila.moveToFirst()) {
                tnombre.setText(fila.getString(0));
                tjuegos.setText(fila.getString(1));
                db.close();
            } else {
                Toast.makeText(this, "no existe el cliente", Toast.LENGTH_LONG).show();
                db.close();
            }

        } else {
            Toast.makeText(this, "Debe ingresar el codigo", Toast.LENGTH_LONG).show();
        }
    }


    public void actualizarCliente(View view)// EJEMPLO DE AÑADIR DATOS A LA BASE DE DATOS
    {
        // traer la base de datos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "juegos", null, 1);
        // permisos de escritura para hacer cambios dentro de la base de datos
        SQLiteDatabase db = admin.getWritableDatabase();

        String cod_cliente = tid.getText().toString();
        String nom_cliente = tnombre.getText().toString();
        String juego_cliente = tjuegos.getText().toString();

        if(!cod_cliente.isEmpty() && !nom_cliente.isEmpty() && !juego_cliente.isEmpty())
        {
            // remplaza los campos de la tabla por los de entrada
            ContentValues cont = new ContentValues();
            cont.put("cod_cliente", cod_cliente);
            cont.put("nombre", nom_cliente);
            cont.put("juego", juego_cliente);

            int cantidad = db.update("clientes", cont, "cod_cliente="+cod_cliente, null);
            db.close();

            if(cantidad == 1)
            {
                Toast.makeText(getBaseContext(),"Se ha actualizado con exito",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getBaseContext(),"Debes llenar campos",Toast.LENGTH_LONG).show();
            }
        }

    }


    public void eliminarCliente(View view)// EJEMPLO DE AÑADIR DATOS A LA BASE DE DATOS
    {
        // traer la base de datos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "juegos", null, 1);
        // permisos de escritura para hacer cambios dentro de la base de datos
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = tid.getText().toString();

        if (!codigo.isEmpty())//si el id no esta vacio
        {
            int cantidad = db.delete("clientes", "cod_cliente="+codigo, null);

            db.close();
            limpiarCampos();

            if(cantidad == 1)
            {
                Toast.makeText(getBaseContext(),"Se ha eliminado el cliente: "+codigo, Toast.LENGTH_LONG).show();
            }else
            {
                Toast.makeText(getBaseContext(),"El cliente no existe", Toast.LENGTH_LONG).show();
            }

        }else
        {
            Toast.makeText(getBaseContext(),"Debe ingresar el codigo", Toast.LENGTH_LONG).show();
        }
    }


    public void limpiarCampos(){
        tid.setText("");
        tnombre.setText("");
        tjuegos.setText("");
    }



}