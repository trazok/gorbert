package com.sunrise.android.risingsun.beverage;
public class VanillaShot extends CondimentDecorator
{
    private static final double PRICE = .50;
    private int shots;

    public VanillaShot(Coffee beverage, int shots)
    {
        super(beverage);
        this.shots = shots;
    }

    public String getOrder()
    {
        return wrappedBeverage.getOrder() + ", " + shots + "x Vanilla";
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
