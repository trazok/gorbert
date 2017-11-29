package com.sunrise.android.risingsun.beverage;
public class Americano extends Coffee 
{
    private static final double PRICE_SMALL = 2.50;
    private static final double PRICE_LARGE = 3.00;
    
    public Americano(int size)
    {
        super();
        mTitle = "Americano";
        mDescription = "Our bold espresso mixed with water";
        this.size = size;
        switch (size)
        {
            case SMALL: 
                mOrder = SIZE_SMALL + " Americano";
                break;
            case LARGE:
                mOrder = SIZE_LARGE + " Americano";
        }
    }
                         
    public double cost() 
    {
        switch (size)
        {
            case SMALL: 
                return PRICE_SMALL;
            case LARGE:
                return PRICE_LARGE;
        }
        
        return -999;
    }
}
