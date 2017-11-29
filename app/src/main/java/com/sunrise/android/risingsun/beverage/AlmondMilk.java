package com.sunrise.android.risingsun.beverage;
public class AlmondMilk extends CondimentDecorator {
    
    private static final double PRICE = .50;

    public AlmondMilk(Coffee beverage) 
    {
        super(beverage);
    }

    public String getDescription()
    {
        return wrappedBeverage.getDescription();
    }
    
    public String getTitle()
    {
        return wrappedBeverage.getTitle();
    }
    
    public String getOrder() {
        return wrappedBeverage.getOrder() + ", almond milk";
    }

    public double cost() {
        return PRICE + wrappedBeverage.cost();
    }
}
