package com.corefield.arch.DATABASE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SignupDatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME2 = "SIGNUP";

    // Table columns
    public static final String ID = "id";
    public static final String USER_NAME = "username";
    public static final String FULL_NAME = "fullname";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";


    // Database Information
    static final String DB_NAME = "SIGNUP1.DB";

    // database version
    static final int DB_VERSION = 2;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME2 + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USER_NAME + " TEXT NOT NULL,"
            + FULL_NAME + " TEXT NOT NULL," + EMAIL + " TEXT NOT NULL," + PASSWORD + " TEXT NOT NULL);";

    public SignupDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);

    }
}