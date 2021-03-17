package com.example.supermarketrating;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "supermarkets.db";
    private static final int DATABASE_VERSION = 1;

    //Database creation sql statement
    private static final String CREATE_TABLE_SUPERMARKET =
             "create table supermarket (_id integer primary key autoincrement, " +
                    "name text not null, streetaddress text, " +
                    "city text, state text, zipcode text);";

    private static final String CREATE_TABLE_RATINGS =
            "create table ratings (_id integer primary key autoincrement, " +
                    "produce text, meat text);";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SUPERMARKET);
        db.execSQL(CREATE_TABLE_RATINGS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS supermarket");
        onCreate(db);
    }
}
