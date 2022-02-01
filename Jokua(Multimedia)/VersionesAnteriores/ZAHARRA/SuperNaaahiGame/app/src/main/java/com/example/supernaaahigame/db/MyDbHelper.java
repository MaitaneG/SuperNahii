package com.example.supernaaahigame.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.supernaaahigame.model.Puntuazioa;
import com.example.supernaaahigame.model.User;

import java.sql.ResultSet;
import java.sql.Statement;

public class MyDbHelper  extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=2;
    private static final String DATABASE_NAME="Txapelketa.db";

    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public   void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + DbBaseColum.TABLE_NAME + " (" +
                DbBaseColum.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DbBaseColum.COLUMN_ID_LANGILEA + " INTEGER NOT NULL," +
                DbBaseColum.COLUMN_PUNTUAZIOA + " INTEGER NOT NULL,"+
                DbBaseColum.COLUMN_DATA+ " TEXT NOT NULL)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DbBaseColum.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }




}



