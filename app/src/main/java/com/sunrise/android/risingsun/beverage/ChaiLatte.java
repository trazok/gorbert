package com.sunrise.android.risingsun.beverage;
public class ChaiLatte extends Coffee 
{
    private static final double PRICE_SMALL = 4.00;
    private static final double PRICE_LARGE = 4.50;
    
    public ChaiLatte(int size)
    {
        super();
        mTitle = "Chai Latte";
        mDescription = "Sweet, spiced chai blended with steamed milk";
        this.size = size;
        switch (size)
        {
            case SMALL: 
                mOrder = SIZE_SMALL + " Chai latte";
                break;
            case LARGE:
                mOrder = SIZE_LARGE + " Chai latte";
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
