package com.example.dbhandler;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

public class Db extends SQLiteOpenHelper {

    private static final String DB_NAME = "user_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "user_details";

    // Column names as constants
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public Db(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME + " TEXT, " +
                USERNAME + " TEXT, " +
                PASSWORD + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addNewUser(String name, String uname, String pwd) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(USERNAME, uname);
        values.put(PASSWORD, pwd);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Boolean checkEmailPassword(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME +
                        " WHERE " + USERNAME + " = ? AND " + PASSWORD + " = ?",
                new String[]{username, password});
        Boolean result = cursor.getCount() > 0;
        cursor.close();
        return result;
    }

    public Cursor getAllUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
}
