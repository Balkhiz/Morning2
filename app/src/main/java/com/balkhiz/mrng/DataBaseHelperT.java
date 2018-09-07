package com.balkhiz.mrng;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBaseHelperT extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "newdata.db";
    public static final String TABLE_NAME = "table_data";
    public static final String COLUMN_NAME = "news";


    public DataBaseHelperT(Context context) {
        super( context, DATABASE_NAME, null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "create table " + TABLE_NAME + "(news STRING PRIMARY KEY)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate( db );

    }

    public boolean insertionData(String news) {
        long result = -1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( COLUMN_NAME, news );
        try {
            result = db.insert( TABLE_NAME, null, contentValues );
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == -1)
            return false;
        else
            return true;

    }
}
