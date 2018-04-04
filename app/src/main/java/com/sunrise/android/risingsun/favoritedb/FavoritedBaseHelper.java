package com.sunrise.android.risingsun.favoritedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sunrise.android.risingsun.FavoriteList;
import com.sunrise.android.risingsun.favoritedb.FavoritedDbSchema;

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
        db.execSQL("create table " + FavoriteList.NAME + "(" +
                " _id integer primary key autoincrement, " +
                FavoriteList.Cols.UUID + ", " +
                FavoriteList.Cols.TITLE + ", " +
                FavoriteList.Cols.DESCRIPTION + ", " +
                FavoriteList.Cols.TYPE + ", " +
                FavoriteList.Cols.FAVORITED +
                ") "
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
