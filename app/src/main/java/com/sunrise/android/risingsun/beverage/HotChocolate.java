package com.sunrise.android.risingsun.beverage;
public class HotChocolate extends Coffee 
{
    private static final double PRICE_SMALL = 2.15;
    private static final double PRICE_LARGE = 2.50;
    
    public HotChocolate(int size)
    {
        mTitle = "Hot Chocolate";
        mDescription = "Hot, creamy milk and lucious chocolate";
        this.size = size;
        switch (size)
        {
            case SMALL: 
                mOrder = SIZE_SMALL + " Hot Chocolate";
                break;
            case LARGE:
                mOrder = SIZE_LARGE + " Hot Chocolate";
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
