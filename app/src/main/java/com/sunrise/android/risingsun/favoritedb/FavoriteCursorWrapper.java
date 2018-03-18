package com.sunrise.android.risingsun.favoritedb;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.sunrise.android.risingsun.Coffee;

import java.util.UUID;

/**
 * Created by dell on 12/14/2017.
 */

public class FavoriteCursorWrapper extends CursorWrapper
{

    public FavoriteCursorWrapper(Cursor cursor)
    {
        super(cursor);
    }

    public Coffee getCoffee()
    {
        String uuidString = getString(getColumnIndex(FavoritedDbSchema.FavoriteTable.Cols.UUID));
        String title = getString(getColumnIndex(FavoritedDbSchema.FavoriteTable.Cols.TITLE));
        //String corder = getString(getColumnIndex(CoffeeDbSchema.CoffeeTable.Cols.CORDER));
        String description = getString(getColumnIndex(FavoritedDbSchema.FavoriteTable.Cols.DESCRIPTION));


        Coffee coffee = new Coffee(UUID.fromString(uuidString));
        coffee.setTitle(title);
        //coffee.setOrder(corder);
        coffee.setDescription(description);

        return coffee;
    }
}
