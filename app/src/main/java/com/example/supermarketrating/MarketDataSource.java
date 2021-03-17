package com.example.supermarketrating;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.sql.SQLException;

public class MarketDataSource {
    private SQLiteDatabase database;
    private DBHelper dbHelper;

    public MarketDataSource(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public boolean insertData(SuperMarket s) {
        boolean didSucceed = false;
        try {
            ContentValues initialValues = new ContentValues();

            initialValues.put("name", s.getName());
            initialValues.put("streetaddress", s.getStreetAddress());
            initialValues.put("city", s.getCity());
            initialValues.put("state", s.getState());
            initialValues.put("zipcode", s.getZipCode());
            didSucceed = database.insert("supermarket", null, initialValues) > 0;
        } catch (Exception e) {
            // Do nothing - will return false if there is an exception
        }
        return didSucceed;
    }

    public boolean insertRating(Rating r) {
        boolean didSucceed = false;
        try {
            ContentValues initialValues = new ContentValues();

            initialValues.put("produce", r.getProduceRating());
            initialValues.put("meat", r.getMeatRating());
            didSucceed = database.insert("ratings", null, initialValues) > 0;
        } catch (Exception e) {
            // Do nothing - will return false if there is an exception
        }
        return didSucceed;
    }
}
