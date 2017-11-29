package com.sunrise.android.risingsun.beverage;
public class WhippedCream extends CondimentDecorator 
{
    private static final double PRICE = .75;
         
    public WhippedCream(Coffee beverage) 
    {
        super(beverage);
    }
                             
    public String getOrder() 
    {
        return wrappedBeverage.getOrder() + ", whipped cream";
    }
                                                 
    public double cost() 
    {
        return PRICE + wrappedBeverage.cost();
    }
    
    public String getDescription()
    {
        return wrappedBeverage.getDescription();
    }
    
    public String getTitle()
    {
        return wrappedBeverage.getTitle();
    }
}
