package com.sunrise.android.risingsun;

import android.content.Context;

import com.sunrise.android.risingsun.beverage.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.jar.Pack200;

/**
 * Created by dell on 11/26/2017.
 */

public class CoffeeShop
{
    private static CoffeeShop sCoffeeShop;

    private List<Coffee> mCoffees;

    public static CoffeeShop get(Context context)
    {
        if (sCoffeeShop == null)
        {
            sCoffeeShop = new CoffeeShop(context);
        }

        return sCoffeeShop;
    }

    private CoffeeShop(Context context)
    {
        mCoffees = new ArrayList<>();

        for(int i = 0; i < 20; i++)
        {
            Coffee coffee = new ColumbianBlend(i % 2);
            coffee.setTitle("Coffee #" + i);
            coffee.setFavorited(i % 2 == 0);

            mCoffees.add(coffee);
        }
    }

    public List<Coffee> getCoffees()
    {
        return mCoffees;
    }

    public Coffee getCoffee(UUID id)
    {
        for (Coffee coffee : mCoffees)
        {
            if (coffee.getId().equals(id))
            {
                return coffee;
            }
        }

        return null;
    }
}
