package database;

// biblioteca sqlite

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    // contrutor para acceder a la base
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // oncreate para contruir sentencias sql
    @Override
    public void onCreate(SQLiteDatabase db) {
        // creamos la tabla
        db.execSQL("CREATE TABLE clientes(cod_cliente int primary key, nombre text, deuda float)");

    }

    // onupgrade para emplear cambios esquematicos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}