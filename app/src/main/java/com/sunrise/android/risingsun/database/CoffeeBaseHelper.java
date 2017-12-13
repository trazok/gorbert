package com.sunrise.android.risingsun.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sunrise.android.risingsun.database.CoffeeDbSchema.CoffeeTable;

/**
 * Created by dell on 12/13/2017.
 */

public class CoffeeBaseHelper extends SQLiteOpenHelper
{
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "coffeeBase.db";

    public CoffeeBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + CoffeeTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                CoffeeTable.Cols.UUID + ", " +
                CoffeeTable.Cols.TITLE + ", " +
                CoffeeTable.Cols.DESCRIPTION + ", " +
                //CoffeeTable.Cols.ORDER + ", " +
                CoffeeTable.Cols.FAVORITED +
                ") "
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
