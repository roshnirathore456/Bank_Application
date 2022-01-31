package com.example.bankingapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ApplicationDB  extends SQLiteOpenHelper{
    public static final String DATABASE_NAME="bank.db";
    public static final String TABLE_NAME="CUSTOMER";
    public static final String col_1= "ID";
    public static final String col_2= "USERNAME";
    public static final String col_3= "PASSWORD";




    public ApplicationDB( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CUSTOMER(ID INTEGER PRIMARY KEY AUTOINCREMENT,USERNAME TEXT,PASSWORD TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

    }
    public long addUser(String username, String password) {
    SQLiteDatabase db =this.getWritableDatabase()   ;
    ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long res=db.insert("CUSTOMER",null ,contentValues);
        db.close();
        return res;

    }
    public boolean checkUser(String USERNAME,String PASSWORD)
    {
        String[] columns = { col_1 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = col_2+ "=?" + " and " + col_3 + "=?";
        String[] selectionArgs ={ USERNAME , PASSWORD };
         Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count =cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return true;
        else
            return false;
    }
}
