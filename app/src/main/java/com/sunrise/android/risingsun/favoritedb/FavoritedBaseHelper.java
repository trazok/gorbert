package com.sunrise.android.risingsun.favoritedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sunrise.android.risingsun.FavoriteList;
import com.sunrise.android.risingsun.favoritedb.FavoritedDbSchema.FavoriteTable;
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
        db.execSQL("create table " + FavoriteTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                FavoriteTable.Cols.UUID + ", " +
                FavoriteTable.Cols.TITLE + ", " +
                FavoriteTable.Cols.DESCRIPTION + ", " +
                FavoriteTable.Cols.TYPE + ", " +
                FavoriteTable.Cols.SIZE + ", " +
                FavoriteTable.Cols.ESPRESSO + ", " +
                FavoriteTable.Cols.CARAMEL + ", " +
                FavoriteTable.Cols.CHOCOLATE + ", " +
                FavoriteTable.Cols.HAZELNUT + ", " +
                FavoriteTable.Cols.VANILLA + ", " +
                FavoriteTable.Cols.WHIPPED + ", " +
                FavoriteTable.Cols.ALMONDMILK + ", " +
                FavoriteTable.Cols.INSTRUCTIONS + ", " +
                FavoriteTable.Cols.FAVORITED +
                ") "
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
