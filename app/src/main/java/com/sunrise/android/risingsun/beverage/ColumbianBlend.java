package com.sunrise.android.risingsun.beverage;
public class ColumbianBlend extends Coffee 
{
    private static final double PRICE_SMALL = 2.00;
    private static final double PRICE_LARGE = 2.25;
    
    public ColumbianBlend(int size)
    {
        super();
        mTitle = "Columbian Coffee";
        mDescription = "Our rich, dark blend";
        this.size = size;
        switch (size)
        {
            case SMALL: 
                mOrder = SIZE_SMALL + " Columbian";
                break;
            case LARGE:
                mOrder = SIZE_LARGE + " Columbian";
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
