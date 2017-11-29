package com.sunrise.android.risingsun.beverage;
public class CaramelShot extends CondimentDecorator
{
    private static final double PRICE = .50;

    public CaramelShot(Coffee beverage)
    {
        super(beverage);
    }

    public String getOrder()
    {
        return wrappedBeverage.getOrder() + ", Caramel";
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
