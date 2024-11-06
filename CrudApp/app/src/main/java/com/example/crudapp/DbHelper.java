package com.example.crudapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static  final String DB_NAME="INVENTORY";
    private static  int DB_VERSION=2;
    private static  final String TABLE_ITEM="Items";
    private  static  final String COL_ITEM_NAME="Item_name";
    private static  final String COL_QUANTITY="Quantity";

    public DbHelper(Context context) {
        super(context, DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_ITEM + " ("
                + COL_ITEM_NAME + " TEXT PRIMARY KEY, "
                + COL_QUANTITY + " INTEGER)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query="DROP TABLE IF EXISTS " +TABLE_ITEM;
        db.execSQL(query);
        onCreate(db);
    }

    public boolean createItem(String item,int qnty)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_ITEM_NAME,item);
        values.put(COL_QUANTITY,qnty);

        long result =db.insert(TABLE_ITEM,null,values);
        //if the value is not inserted return -1
        return result != -1;
    }
    public boolean updateItem(String item, int qnty)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues values = new ContentValues();


        values.put(COL_QUANTITY,qnty);

        return db.update(TABLE_ITEM,values,COL_ITEM_NAME +"=?",new String[]{item})>0;
    }
    public Cursor readItems()
    {
        SQLiteDatabase db =this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_ITEM,null);

    }
    public boolean deleteItem(String item)
    {
        SQLiteDatabase db =this.getReadableDatabase();
        return db.delete(TABLE_ITEM,COL_ITEM_NAME +"=?",new String[]{item})>0;
    }

}
