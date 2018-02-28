package com.gorbert.android.rosebud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.gorbert.android.rosebud.favoritedb.FavoriteCursorWrapper;
import com.gorbert.android.rosebud.favoritedb.FavoritedBaseHelper;
import com.gorbert.android.rosebud.favoritedb.FavoritedDbSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by dell on 12/14/2017.
 */

public class FavoriteList
{

    private static FavoriteList sFavoriteList;

    private Context mContext;
    private SQLiteDatabase mDatabase;


    public static FavoriteList get(Context context)
    {
        if (sFavoriteList == null)
        {
            sFavoriteList = new FavoriteList(context);
        }

        return sFavoriteList;
    }

    private FavoriteList(Context context)
    {
        mContext = context.getApplicationContext();
        mDatabase = new FavoritedBaseHelper(mContext)
                .getWritableDatabase();


    }

    public void addCoffee(Coffee c)
    {
        ContentValues values = getContentValues(c);
        mDatabase.insert(FavoritedDbSchema.FavoriteTable.NAME, null, values);
    }

    public List<Coffee> getCoffees()
    {
        List<Coffee> coffees = new ArrayList<>();

        FavoriteCursorWrapper cursor = queryCoffees(null, null);

        try
        {
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                coffees.add(cursor.getCoffee());
                cursor.moveToNext();
            }
        }
        finally
        {
            cursor.close();
        }

        return coffees;
    }

    public Coffee getCoffee(UUID id)
    {
        FavoriteCursorWrapper cursor = queryCoffees(
                FavoritedDbSchema.FavoriteTable.Cols.UUID + " = ?",
                new String[] {id.toString()}
        );

        try
        {
            if (cursor.getCount() == 0)
            {
                return null;
            }

            cursor.moveToFirst();
            return cursor.getCoffee();
        }
        finally
        {
            cursor.close();
        }
    }

    public void updateCoffee(Coffee coffee)
    {
        String uuidString = coffee.getId().toString();
        ContentValues values = getContentValues(coffee);

        mDatabase.update(FavoritedDbSchema.FavoriteTable.NAME, values,
                FavoritedDbSchema.FavoriteTable.Cols.UUID + " = ?",
                new String[] {uuidString});
    }

    private FavoriteCursorWrapper queryCoffees(String whereClause, String[] whereArgs)
    {
        Cursor cursor = mDatabase.query(
                FavoritedDbSchema.FavoriteTable.NAME,
                null, //columns - null selects all columns
                whereClause,
                whereArgs,
                null, //groupBy
                null, //having
                null //orderBy
        );
        return new FavoriteCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(Coffee coffee)
    {
        ContentValues values = new ContentValues();
        values.put(FavoritedDbSchema.FavoriteTable.Cols.UUID, coffee.getId().toString());
        values.put(FavoritedDbSchema.FavoriteTable.Cols.TITLE, coffee.getTitle());
        values.put(FavoritedDbSchema.FavoriteTable.Cols.DESCRIPTION, coffee.getDescription());
        //values.put(CoffeeTable.Cols.ORDER, coffee.getOrder());

        return values;
    }
}
