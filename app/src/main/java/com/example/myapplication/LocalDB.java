package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class LocalDB {

    private static final String DATABASE_NAME = "simple.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "table1";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_MISTAKE = "mistake";
    private static final String COLUMN_TIME = "time";
    private static final String COLUMN_BOOLEANS = "booleans";

    private static final int NUM_COLUMN_ID = 0;
    private static final int NUM_COLUMN_MISTAKE = 1;
    private static final int NUM_COLUMN_TIME = 2;
    private static final int NUM_COLUMN_BOOLEANS = 3;

    private SQLiteDatabase mDataBase;

    public LocalDB(Context context) {
        OpenHelper mOpenHelper = new OpenHelper(context);
        mDataBase = mOpenHelper.getWritableDatabase();
    }

    public long insert(String time,boolean[] booleans ,int mistake) {
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_MISTAKE, mistake);
        cv.put(COLUMN_TIME, time);
        cv.put(COLUMN_BOOLEANS, String.valueOf(booleans));
        return mDataBase.insert(TABLE_NAME, null, cv);
    }

    private class OpenHelper extends SQLiteOpenHelper {

        OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_MISTAKE+ " INT, " +
                    COLUMN_TIME + " TEXT, " +
                    COLUMN_BOOLEANS + " INT "+ ";";
            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }

}
