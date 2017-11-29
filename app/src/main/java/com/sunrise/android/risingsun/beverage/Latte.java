package com.sunrise.android.risingsun.beverage;
public class Latte extends CondimentDecorator 
{
    private static final double PRICE_LARGE = 1.50;
    private static final double PRICE_SMALL = 1.25;
    
         
    public Latte(Coffee beverage) 
    {
        super(beverage);
        wrappedBeverage.setTitle("Latte");
        wrappedBeverage.setDescription("A rich blend of steamed milk and espresso");   
    }
                             
    public String getDescription()
    {
        return wrappedBeverage.getDescription();
    }
    
    public String getTitle()
    {
        return wrappedBeverage.getTitle();
    }
    
    public String getOrder() 
    {
        return wrappedBeverage.getOrder() + " latte";
    }
                                                 
    public double cost() 
    {
        switch (wrappedBeverage.size)
        {
            case SMALL: 
                return PRICE_SMALL + wrappedBeverage.cost();
            case LARGE:
                return PRICE_LARGE + wrappedBeverage.cost();
        }
        
        return -999;
    }
}
