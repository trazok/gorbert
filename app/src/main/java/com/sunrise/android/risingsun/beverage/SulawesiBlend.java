package com.sunrise.android.risingsun.beverage;
public class SulawesiBlend extends Coffee 
{
    private static final double PRICE_SMALL = 2.00;
    private static final double PRICE_LARGE = 2.25;
    
    public SulawesiBlend(int size)
    {
        super();
        mTitle = "Sulawesi Coffee";
        mDescription = "Our light, nutty roast";
        this.size = size;
        switch (size)
        {
            case SMALL: 
                mOrder = SIZE_SMALL + " Sulawesi";
                break;
            case LARGE:
                mOrder = SIZE_LARGE + " Sulawesi";
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
