package com.gorbert.android.rosebud;



/**
 * Created by dell on 2/6/2018.
 */

public class Tea extends Coffee
{
    private String[] mTeaTypes= {"Green", "British Breakfast", "Earl Grey", "Acai Green", "Tumeric Ginger",
        "Tumeric", "Peppermint Chocolate", "Darjeeling", "Hibiscus", "Milk Oolong"};

    private int mTeaType;

    public Tea(int teaType)
    {

        mTeaType = teaType;

    }

    @Override
    public String toString()
    {
        String orderSummary = "DEFAULT TEA";

        if (getSize() == 0)
        {
            orderSummary = "Small ";
        }
        else
        {
            orderSummary = "Large ";
        }

        orderSummary += mTeaTypes[mTeaType] + ";";

        if (getAlmondMilk())
            orderSummary += " almond milk";
        if (getEspressoShots() > 0)
            orderSummary += " " + getEspressoShots() + "espresso;";
        if (getVanillaShots() > 0)
            orderSummary += " " + getVanillaShots() + "vanilla;";
        if (getChocolateShots() > 0)
            orderSummary += " " + getChocolateShots() + "chocolate;";
        if (getHazelnutShots() > 0)
            orderSummary += " " + getHazelnutShots() + "hazelnut;";
        if (getCaramelShots() > 0)
            orderSummary += " " + getCaramelShots() + "caramel;";
        if (getWhippedCream())
            orderSummary += " " + getWhippedCream() + "whipped cream;";



        return orderSummary;
    }
}
