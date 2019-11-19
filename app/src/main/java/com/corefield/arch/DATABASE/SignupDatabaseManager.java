package com.corefield.arch.DATABASE;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class SignupDatabaseManager  {

    private SignupDatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public SignupDatabaseManager(Context c) { context =  c; }

    public SignupDatabaseManager open() throws SQLException {

        dbHelper = new SignupDatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {

        dbHelper.close();
    }

    public void insert(String username, String fullname, String email, String password) {

        ContentValues contentValue = new ContentValues();
        contentValue.put(SignupDatabaseHelper.USER_NAME, username);
        contentValue.put(SignupDatabaseHelper.FULL_NAME, fullname);
        contentValue.put(SignupDatabaseHelper.EMAIL, email);
        contentValue.put(SignupDatabaseHelper.PASSWORD, password);
        database.insert(SignupDatabaseHelper.TABLE_NAME2, null, contentValue);

    }

    public Cursor fetch() {

        String[] columns = new String[]{

                SignupDatabaseHelper.ID,
                SignupDatabaseHelper.USER_NAME,
                SignupDatabaseHelper.FULL_NAME,
                SignupDatabaseHelper.EMAIL,
                SignupDatabaseHelper.PASSWORD
        };

        Cursor cursor = database.query(SignupDatabaseHelper.TABLE_NAME2, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String username, String fullname, String email, String password) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SignupDatabaseHelper.USER_NAME, username);
        contentValues.put(SignupDatabaseHelper.FULL_NAME, fullname);
        contentValues.put(SignupDatabaseHelper.EMAIL, email);
        contentValues.put(SignupDatabaseHelper.PASSWORD, password);
        int i = database.update(SignupDatabaseHelper.TABLE_NAME2, contentValues, SignupDatabaseHelper.ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(SignupDatabaseHelper.TABLE_NAME2, SignupDatabaseHelper.ID + "=" + _id, null);
    }



}
