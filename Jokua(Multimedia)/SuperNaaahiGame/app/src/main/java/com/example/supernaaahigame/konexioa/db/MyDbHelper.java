package com.example.supernaaahigame.konexioa.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.supernaaahigame.model.User;

import java.util.ArrayList;

public class MyDbHelper  extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="Txapelketa_DB";

    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + DBUser.DbBaseColumn.TABLE_NAME + " (" +
                DBUser.DbBaseColumn.COLUMN_USERNAME + " TEXT PRIMARY KEY," +
                DBUser.DbBaseColumn.COLUMN_PASSWORD+ " TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DBUser.TABLE_NAME);
//        onCreate(sqLiteDatabase);

    }
    public boolean addUser(User users){
        SQLiteDatabase db=getWritableDatabase();

        ContentValues values= new ContentValues();

        values.put(DBUser.DbBaseColumn.COLUMN_USERNAME,users.getEmail());
        values.put(DBUser.DbBaseColumn.COLUMN_PASSWORD,users.getPass());

        long sid= db.insert(DBUser.DbBaseColumn.TABLE_NAME, null,values);

        if(sid>0){
            return  true;
        }else{
            return false;
        }
    }

    public ArrayList<User> selectUser(){
        SQLiteDatabase db=getWritableDatabase();

        Cursor c= db.rawQuery("SELECT * FROM app_users", null);
        ArrayList<User> users=new ArrayList<>();

        if(c.moveToFirst()){
            do{
                users.add(new User(c.getString(0),c.getString(1)));
            }while(c.moveToNext());
        }
        return users;
    }
}