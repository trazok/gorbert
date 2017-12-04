package com.sunrise.android.risingsun;

import com.sunrise.android.risingsun.beverage.Coffee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 12/1/2017.
 */

public class ShoppingCart
{
    private List<Coffee> order;
    private static ShoppingCart cartInstance = new ShoppingCart();

    private ShoppingCart()
    {
        order = new ArrayList<Coffee>();
    }

    public void add(Coffee coffee)
    {
        order.add(coffee);
    }

    public static ShoppingCart getInstance()
    {
        return cartInstance;
    }

    public void remove(Coffee coffee)
    {
        order.remove(coffee);
    }

    public double total()
    {
        double total = 0;

        for (Coffee coffee : order)
        {
            total += coffee.cost();
        }

        return total;
    }

    public void placeOrder()
    {

    }
}
