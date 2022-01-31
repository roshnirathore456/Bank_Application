package com.example.bankingapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class UserHelper extends SQLiteOpenHelper {

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";
    public final static String TABLE_NAME = "user";

    /** Table Fields */
    public final static String _ID = BaseColumns._ID;
    public final static String COLUMN_USER_NAME ="name";
    public final static String COLUMN_USER_ACCOUNT_NUMBER ="accountNo";
    public final static String COLUMN_USER_EMAIL ="email";
    public final static String COLUMN_USER_IFSC_CODE ="ifscCode";
    public final static String COLUMN_USER_PHONE_NO ="phoneNo";
    public final static String COLUMN_USER_ACCOUNT_BALANCE ="balance";


    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + COLUMN_USER_NAME + " VARCHAR, "
                + COLUMN_USER_EMAIL + " VARCHAR, "
                + COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + COLUMN_USER_PHONE_NO + " VARCHAR, "
                + COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";
        db.execSQL(SQL_CREATE_USER_TABLE);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }

    public String addRecords(String name, String accountNo,String email,String ifscCode,String phoneNo,String balance, int i) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("accountNo", accountNo);
        contentValues.put("email",email);
        contentValues.put("ifscCode",ifscCode);
        contentValues.put("phoneNo",phoneNo);
        contentValues.put("balance",balance);
        float res = db.insert("user", null, contentValues);
        if(res== -1)
            return "failed";
        else
            return "pass";


    }


    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " +TABLE_NAME + " where " +
                                        COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + TABLE_NAME + " set " + COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " + COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}