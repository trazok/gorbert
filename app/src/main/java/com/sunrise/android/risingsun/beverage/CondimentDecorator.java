package com.sunrise.android.risingsun.beverage;
public abstract class CondimentDecorator extends Coffee 
{
    protected Coffee wrappedBeverage;
    
    public CondimentDecorator(Coffee beverage)
    {
        wrappedBeverage = beverage;
    }
    
    public abstract String getDescription();
    
    public abstract String getTitle();
    
    public abstract String getOrder();

    public boolean isFavorited()
    {
        return wrappedBeverage.isFavorited();
    }

    public void setFavorited(boolean favorited)
    {
        wrappedBeverage.setFavorited(favorited);
    }
    
    public double cost()
    {
        return 0;
    }
}
