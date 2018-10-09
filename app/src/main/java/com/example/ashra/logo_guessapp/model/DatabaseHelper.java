package com.example.ashra.logo_guessapp.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME+"("+Col_1+" integer primary key autoincrement, "+col_2+" TEXT, "+col_3+", integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE "+TABLE_NAME);
        onCreate(db);
    }

    public static final String DATABASE_NAME = "App.db";
    public static final String TABLE_NAME = "User";
    public static final String Col_1 = "id";
    public static final String col_2 = "name";
    public static final String col_3 = "score";

}
