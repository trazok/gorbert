package com.sunrise.android.risingsun.favoritedb;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.sunrise.android.risingsun.Coffee;

import java.util.UUID;
import com.sunrise.android.risingsun.FavoriteList;

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

        String uuidString = getString(getColumnIndex(FavoritedDbSchema.FavoriteList.Cols.UUID));
        String title = getString(getColumnIndex(FavoritedDbSchema.FavoriteList.Cols.TITLE));
        //String corder = getString(getColumnIndex(FavoritedDbSchema.FavoriteList.Cols.CORDER));
        String description = getString(getColumnIndex(FavoritedDbSchema.FavoriteList.Cols.DESCRIPTION));
        int isFavorited = getInt(getColumnIndex(FavoritedDbSchema.FavoriteList.Cols.FAVORITED));
        int coffeeType = getInt(getColumnIndex(FavoritedDbSchema.FavoriteList.Cols.TYPE));


        Coffee coffee = new Coffee(UUID.fromString(uuidString));
        coffee.setTitle(title);
        //coffee.setOrder(corder);
        coffee.setDescription(description);
        coffee.setFavorited(isFavorited != 0);
        coffee.setSize(Coffee.LARGE);
        coffee.setDrinkType(coffeeType);

        return coffee;
    }
}
