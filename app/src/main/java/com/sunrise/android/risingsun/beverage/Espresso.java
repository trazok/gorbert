package com.sunrise.android.risingsun.beverage;
public class Espresso extends CondimentDecorator
{
    private static final double PRICE = .70;
    private int shots;

    public Espresso(Coffee beverage, int shots)
    {
        super(beverage);
        this.shots = shots;
    }

    public String getOrder()
    {
        return wrappedBeverage.getOrder() + ", " + shots + "x espresso";
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
