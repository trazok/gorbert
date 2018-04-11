package com.sunrise.android.risingsun;

import java.util.UUID;

/**
 * Created by dell on 2/4/2018.
 */

public class Coffee
{
    public static final double ESPRESSO_PRICE = .70;
    public static final double FLAVOR_PRICE = .50;
    public static final double WHIPPED_PRICE = .75;
    public static final double ALMOND_MILK_PRICE = 1.00;

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


    protected int mSize;
    protected int mDrinkType;
    protected int mEspressoShots;
    protected int mCaramelShots;
    protected int mChocolateShots;
    protected int mHazelnutShots;
    protected int mVanillaShots;
    protected boolean mWhippedCream;
    protected boolean mAlmondMilk;
    protected boolean isFavorited;

    protected String mSpecialInstructions = null;
    protected String mTitle = "Default Coffee";
    protected String mDescription = "Unknown Beverage";
    private UUID mId;




    private double[][] mBasePrices = {{1.95, 2.00, 2.00, 3.25, 3.25, 2.15, 4.00, 2.50},  //small prices
            {2.45, 2.25, 2.25, 3.75, 3.75, 2.50, 4.50, 3.00}   //large prices
    };

    public Coffee()
    {
        this(UUID.randomUUID());
    }

    public Coffee(UUID id)
    {
        mId = id;
    }

    public Coffee cloneCoffee()
    {
        Coffee clone = new Coffee();

        clone.setDrinkType(mDrinkType);
        clone.setSize(mSize);
        clone.setTitle(mTitle);
        clone.setDescription(mDescription);

        return clone;
    }

    public UUID getId()
    {
        return mId;
    }

    public boolean isFavorited()
    {
        return isFavorited;
    }

    public void setFavorited(boolean favorite)
    {
        isFavorited = favorite;
    }

    public String getSpecialInstructions()
    {
        return mSpecialInstructions;
    }

    public void setSpecialInstructions(String instructions)
    {
        mSpecialInstructions = instructions;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public void setTitle(String title)
    {
        mTitle = title;
    }

    public String getDescription()
    {
        return mDescription;
    }

    public void setDescription(String description)
    {
        mDescription = description;
    }

    public double cost()
    {
        double price = mBasePrices[mSize][mDrinkType];

        price += (mEspressoShots * ESPRESSO_PRICE)  +
                ((mCaramelShots + mChocolateShots + mHazelnutShots + mVanillaShots) * FLAVOR_PRICE);

        if (mAlmondMilk)
            price += ALMOND_MILK_PRICE;

        if (mWhippedCream)
            price += WHIPPED_PRICE;

        return price;
    }

    public String toString()
    {
        String orderSummary = "DEFAULT ORDER";

        if (mSize == SMALL)
        {
            orderSummary = "Small ";
        }
        else
        {
            orderSummary = "Large ";
        }

        switch (mDrinkType)
        {
            case 0: orderSummary += "ERROR, TEA CASE";
                break;
            case 1: orderSummary += "Columbian";
                break;
            case 2: orderSummary += "Sulawesi";
                break;
            case 3: orderSummary += "latte";
                break;
            case 4: orderSummary += "cappuccino";
                break;
            case 5: orderSummary += "hot chocolate";
                break;
            case 6: orderSummary += "chai latte";
                break;
            case 7: orderSummary += "americano";
                break;
            default: orderSummary += "ERROR, DEFAULT CASE";
                break;
        }

        if (mAlmondMilk)
            orderSummary += ", almond milk";
        if (mEspressoShots > 0)
            orderSummary += ", " + mEspressoShots + " espresso";
        if (mVanillaShots > 0)
            orderSummary += ", " + mVanillaShots + " vanilla";
        if (mChocolateShots > 0)
            orderSummary += ", " + mChocolateShots + " chocolate";
        if (mHazelnutShots > 0)
            orderSummary += ", " + mHazelnutShots + " hazelnut";
        if (mCaramelShots > 0)
            orderSummary += ", " + mCaramelShots + " caramel";
        if (mWhippedCream)
            orderSummary += ", whipped cream";


        return orderSummary;
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

    public boolean getAlmondMilk()  {return mAlmondMilk;}

    public void setAlmondMilk(boolean almondMilk)    {mAlmondMilk = almondMilk;}

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

    public boolean getWhippedCream()
    {
        return mWhippedCream;
    }

    public void setWhippedCream(boolean whippedCream)
    {
        mWhippedCream = whippedCream;
    }

}

