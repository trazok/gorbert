package com.sunrise.android.risingsun.beverage;
public class HazelnutShot extends CondimentDecorator
{
    private static final double PRICE = .50;
    private int shots;

    public HazelnutShot(Coffee beverage, int shots)
    {
        super(beverage);
        this.shots = shots;
    }

    public String getOrder()
    {
        return wrappedBeverage.getOrder() + ", " + shots + "x Hazelnut";
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
