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
        //String corder = getString(getColumnIndex(FavoritedDbSchema.FavoriteList.Cols.CORDER));
        String description = getString(getColumnIndex(FavoritedDbSchema.FavoriteTable.Cols.DESCRIPTION));
        int isFavorited = getInt(getColumnIndex(FavoritedDbSchema.FavoriteTable.Cols.FAVORITED));
        int coffeeType = getInt(getColumnIndex(FavoritedDbSchema.FavoriteTable.Cols.TYPE));
        int coffeeSize = getInt(getColumnIndex(FavoritedDbSchema.FavoriteTable.Cols.SIZE));
        int espressoShots = getInt(getColumnIndex(FavoritedDbSchema.FavoriteTable.Cols.ESPRESSO));
        int caramelShots = getInt(getColumnIndex(FavoritedDbSchema.FavoriteTable.Cols.CARAMEL));
        int chocolateShots = getInt(getColumnIndex(FavoritedDbSchema.FavoriteTable.Cols.CHOCOLATE));
        int hazelnutShots = getInt(getColumnIndex(FavoritedDbSchema.FavoriteTable.Cols.HAZELNUT));
        int vanillaShots = getInt(getColumnIndex(FavoritedDbSchema.FavoriteTable.Cols.VANILLA));
        boolean whippedCream = getInt(getColumnIndex(FavoritedDbSchema.FavoriteTable.Cols.WHIPPED)) > 0;
        boolean almondMilk = getInt(getColumnIndex(FavoritedDbSchema.FavoriteTable.Cols.ALMONDMILK)) > 0;
        String specialInstructions = getString(getColumnIndex(FavoritedDbSchema.FavoriteTable.Cols.INSTRUCTIONS));




        Coffee coffee = new Coffee(UUID.fromString(uuidString));
        coffee.setTitle(title);
        //coffee.setOrder(corder);
        coffee.setDescription(description);
        coffee.setFavorited(isFavorited != 0);
        coffee.setSize(Coffee.SMALL);
        coffee.setDrinkType(coffeeType);
        coffee.setSize(coffeeSize);
        coffee.setEspressoShots(espressoShots);
        coffee.setCaramelShots(caramelShots);
        coffee.setChocolateShots(chocolateShots);
        coffee.setHazelnutShots(hazelnutShots);
        coffee.setVanillaShots(vanillaShots);
        coffee.setWhippedCream(whippedCream);
        coffee.setAlmondMilk(almondMilk);
        coffee.setSpecialInstructions(specialInstructions);

        return coffee;
    }
}
