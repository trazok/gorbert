package com.sunrise.android.risingsun;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by trazo on 4/11/2018.
 */
public class CoffeeTest {

    @Test
    public void testCostCalculation()
    {
        Coffee testCoffee = new Coffee();
        testCoffee.setSize(Coffee.SMALL);
        testCoffee.setDrinkType(Coffee.SULAWESI);

        double expected = 2.00;
        double actual = testCoffee.cost();

        assertEquals(expected, actual, 0);
    }

    @Test
    public void testCostCalculation2()
    {
        Coffee testCoffee = new Coffee();
        testCoffee.setSize(Coffee.LARGE);
        testCoffee.setDrinkType(Coffee.CHAI_LATTE);

        double expected = 4.50;
        double actual = testCoffee.cost();

        assertEquals(expected, actual, 0);
    }

    @Test
    public void testCostCalculation3()
    {
        Coffee testCoffee = new Coffee();
        testCoffee.setSize(Coffee.SMALL);
        testCoffee.setDrinkType(Coffee.LATTE);  //3.25
        testCoffee.setWhippedCream(true);       //.75
        testCoffee.setEspressoShots(4);         //.70 * 4

        double expected = 6.80;
        double actual = testCoffee.cost();

        assertEquals(expected, actual, 0);
    }
    @Test
    public void testCostCalculation4()
    {
        Coffee testCoffee = new Coffee();
        testCoffee.setSize(Coffee.LARGE);
        testCoffee.setDrinkType(Coffee.HOT_CHOCOLATE);  //2.5
        testCoffee.setWhippedCream(true);   //.75
        testCoffee.setAlmondMilk(true);     //1.00
        testCoffee.setCaramelShots(3);      //.5 * 3
        testCoffee.setEspressoShots(2);     //.70 * 2
        testCoffee.setVanillaShots(1);      //.50

        double expected = 7.65;
        double actual = testCoffee.cost();

        assertEquals(expected, actual, 0);
    }

    @Test
    public void testToString()
    {
        Coffee testCoffee = new Coffee();
        testCoffee.setSize(Coffee.LARGE);
        testCoffee.setDrinkType(Coffee.CAPPUCCINO);
        testCoffee.setWhippedCream(true);
        testCoffee.setAlmondMilk(true);
        testCoffee.setEspressoShots(4);
        testCoffee.setHazelnutShots(2);
        testCoffee.setVanillaShots(1);

        String actual = testCoffee.toString();
        String expected = "Large cappuccino, almond milk, 4 espresso, 1 vanilla, 2 hazelnut, whipped cream";

        assertTrue("expected: " + expected + "; got: " + actual, actual.equals(expected));

    }


    /*
        Things to make tests for:
        -------------------------

        order total
        server communication
        coffee made is the coffee wanted
        coffee is placed in cart
        cost calculated correctly
        cost  displayed correctly
        menu navigation correct
        saved/removed from DB correctly
        cart updates changes
        
     */


}