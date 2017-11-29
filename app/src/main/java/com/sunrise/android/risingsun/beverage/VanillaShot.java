package com.sunrise.android.risingsun.beverage;
public class VanillaShot extends CondimentDecorator
{
    private static final double PRICE = .50;

    public VanillaShot(Coffee beverage)
    {
        super(beverage);
    }

    public String getOrder()
    {
        return wrappedBeverage.getOrder() + ", Vanilla";
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
