package com.gorbert.android.rosebud.favoritedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.gorbert.android.rosebud.database.CoffeeDbSchema;

/**
 * Created by dell on 12/14/2017.
 */

public class FavoritedBaseHelper extends SQLiteOpenHelper
{

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "favoriteBase.db";

    public FavoritedBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + CoffeeDbSchema.CoffeeTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                CoffeeDbSchema.CoffeeTable.Cols.UUID + ", " +
                CoffeeDbSchema.CoffeeTable.Cols.TITLE + ", " +
                CoffeeDbSchema.CoffeeTable.Cols.DESCRIPTION + ", " +
                //CoffeeTable.Cols.CORDER + ", " +
                ") "
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
