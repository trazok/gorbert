package com.gorbert.android.rosebud;

/**
 * Created by dell on 2/4/2018.
 */

public class Beverage
{
    public static final int LARGE = 2;
    public static final int SMALL = 1;

    public static final int COLUMBIAN = 3;
    public static final int SULAWESI = 4;
    public static final int LATTE = 5;
    public static final int CAPPUCCINO = 6;
    public static final int HOT_CHOCOLATE = 7;
    public static final int CHAI_LATTE = 8;
    public static final int TEA = 9;

    private int mEspressoShots;
    private int mCaramelShots;
    private int mChocolateShots;
    private int mHazelnutShots;
    private int mVanillaShots;
    private int mWhippedCream;

    public Beverage(int size, int drinkType)
    {

    }

    public double cost()
    {
        return 0;
    }

    public String toString()
    {
        return "";
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

