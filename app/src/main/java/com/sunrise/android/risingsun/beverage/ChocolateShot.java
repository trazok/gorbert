package com.sunrise.android.risingsun.beverage;
public class ChocolateShot extends CondimentDecorator
{
    private static final double PRICE = .50;

    public ChocolateShot(Coffee beverage)
    {
        super(beverage);
    }

    public String getOrder()
    {
        return wrappedBeverage.getOrder() + ", Chocolate";
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
