package com.example.bankingapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AccountDB extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "addAcc.db";
    public static final String TABLE_NAME = "CUSTOMER";
    public static final String col_1= "ACCOUNT_NAME";
    public static final String col_2= "ACCOUNT_NUMBER";
    public static final String col_3= "AMMOUNT";

    public AccountDB( Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry="CREATE TABLE CUSTOMER(ID INTEGER PRIMARY KEY AUTOINCREMENT,ACCOUNT_NAME TEXT,ACCOUNT_NUMBER TEXT,AMMOUNT Integer)";
         db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS CUSTOMER");
    }

    public String addRecords(String ACCOUNT_NAME, String ACCOUNT_NUMBER, String AMMOUNT, int i) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ACCOUNT_NAME", ACCOUNT_NAME);
        contentValues.put("ACCOUNT_NUMBER", ACCOUNT_NUMBER);
        contentValues.put("AMMOUNT",AMMOUNT);
        float res = db.insert("CUSTOMER", null, contentValues);
        if(res== -1)
            return "failed";
        else
            return "pass";


    }
    public Cursor readalldata()
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String qry = "select * from CUSTOMER order by ID desc";

        Cursor cursor = sqLiteDatabase.rawQuery(qry,null);
        return cursor;

    }
}
