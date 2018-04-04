package com.sunrise.android.risingsun.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.sunrise.android.risingsun.Coffee;

import java.util.UUID;

/**
 * Created by dell on 12/13/2017.
 */

public class CoffeeCursorWrapper extends CursorWrapper
{
    public CoffeeCursorWrapper(Cursor cursor)
    {
        super(cursor);
    }

    public Coffee getCoffee()
    {
        String uuidString = getString(getColumnIndex(CoffeeDbSchema.CoffeeTable.Cols.UUID));
        String title = getString(getColumnIndex(CoffeeDbSchema.CoffeeTable.Cols.TITLE));
        //String corder = getString(getColumnIndex(CoffeeDbSchema.CoffeeTable.Cols.CORDER));
        String description = getString(getColumnIndex(CoffeeDbSchema.CoffeeTable.Cols.DESCRIPTION));
        int isFavorited = getInt(getColumnIndex(CoffeeDbSchema.CoffeeTable.Cols.FAVORITED));
        int coffeeType = getInt(getColumnIndex(CoffeeDbSchema.CoffeeTable.Cols.TYPE));


        Coffee coffee = new Coffee(UUID.fromString(uuidString));
        coffee.setTitle(title);
        //coffee.setOrder(corder);
        coffee.setDescription(description);
        coffee.setFavorited(isFavorited != 0);
        coffee.setSize(Coffee.SMALL);
        coffee.setDrinkType(coffeeType);

        return coffee;
    }
}
