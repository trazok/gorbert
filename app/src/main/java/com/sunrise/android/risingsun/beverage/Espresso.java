package com.sunrise.android.risingsun.beverage;
public class Espresso extends CondimentDecorator
{
    private static final double PRICE = .70;

    public Espresso(Coffee beverage)
    {
        super(beverage);
    }

    public String getOrder()
    {
        return wrappedBeverage.getOrder() + ", espresso";
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
