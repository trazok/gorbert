package com.gorbert.android.rosebud;

/**
 * Created by dell on 2/4/2018.
 */

public class Beverage
{
    public static final double ESPRESSO_PRICE = .70;
    public static final double FLAVOR_PRICE = .50;
    public static final double WHIPPED_PRICE = .75;

    public static final int LARGE = 1;
    public static final int SMALL = 0;

    public static final int TEA = 0;
    public static final int COLUMBIAN = 1;
    public static final int SULAWESI = 2;
    public static final int LATTE = 3;
    public static final int CAPPUCCINO = 4;
    public static final int HOT_CHOCOLATE = 5;
    public static final int CHAI_LATTE = 6;
    public static final int AMERICANO = 7;

    private int mSize;
    private int mDrinkType;
    private int mEspressoShots;
    private int mCaramelShots;
    private int mChocolateShots;
    private int mHazelnutShots;
    private int mVanillaShots;
    private int mWhippedCream;

    private double mPrice;

    private double[][] mBasePrices = {{1.95, 2.00, 2.00, 3.25, 3.25, 2.15, 4.00, 2.50},
            {2.45, 2.25, 2.25, 3.75, 3.75, 2.50, 4.50, 3.00}
    };

    public Beverage(int size, int drinkType)
    {
        mPrice = mBasePrices[size][drinkType];
        mSize = size;
        mDrinkType = drinkType;
    }

    public double cost()
    {
        double price = mPrice + (mEspressoShots * ESPRESSO_PRICE) + (mWhippedCream * WHIPPED_PRICE) +
                ((mCaramelShots + mChocolateShots + mHazelnutShots + mVanillaShots) * FLAVOR_PRICE);

        return price;
    }

    public String toString()
    {
        return "";
    }

    public double getPrice()
    {
        return mPrice;
    }

    public int getSize()
    {
        return mSize;
    }

    public void setSize(int size)
    {
        mSize = size;
    }

    public int getDrinkType()
    {
        return mDrinkType;
    }

    public void setDrinkType(int drinkType)
    {
        mDrinkType = drinkType;
    }

    public void setPrice(double price)
    {
        mPrice = price;
    }

    public int getEspressoShots()
    {
        return mEspressoShots;
    }

    public void setEspressoShots(int espressoShots)
    {
        mEspressoShots = espressoShots;
    }

    public int getCaramelShots()
    {
        return mCaramelShots;
    }

    public void setCaramelShots(int caramelShots)
    {
        mCaramelShots = caramelShots;
    }

    public int getChocolateShots()
    {
        return mChocolateShots;
    }

    public void setChocolateShots(int chocolateShots)
    {
        mChocolateShots = chocolateShots;
    }

    public int getHazelnutShots()
    {
        return mHazelnutShots;
    }

    public void setHazelnutShots(int hazelnutShots)
    {
        mHazelnutShots = hazelnutShots;
    }

    public int getVanillaShots()
    {
        return mVanillaShots;
    }

    public void setVanillaShots(int vanillaShots)
    {
        mVanillaShots = vanillaShots;
    }

    public int getWhippedCream()
    {
        return mWhippedCream;
    }

    public void setWhippedCream(int whippedCream)
    {
        mWhippedCream = whippedCream;
    }

}

