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


    @Test
    public void testCartTotal()
    {
        ShoppingCart testCart = ShoppingCart.getInstance();

        Coffee testCoffee0 = new Coffee();
        testCoffee0.setSize(Coffee.SMALL);
        testCoffee0.setDrinkType(Coffee.CHAI_LATTE);    //4.00
        Coffee testCoffee1 = new Coffee();
        testCoffee1.setSize(Coffee.LARGE);
        testCoffee1.setDrinkType(Coffee.SULAWESI);      //2.25
        Coffee testCoffee2 = new Coffee();
        testCoffee2.setSize(Coffee.LARGE);
        testCoffee2.setDrinkType(Coffee.HOT_CHOCOLATE); //2.50
        Coffee testCoffee3 = new Coffee();
        testCoffee3.setSize(Coffee.SMALL);
        testCoffee3.setDrinkType(Coffee.LATTE);         //3.25
        testCoffee3.setWhippedCream(true);              //.75



        testCart.add(testCoffee0);
        testCart.add(testCoffee1);
        testCart.add(testCoffee2);
        testCart.add(testCoffee3);

        double expected = 12.75;
        double actual = testCart.total();

        assertEquals(expected, actual, 0);
    }

    @Test
    public void testServer()
    {

    }

    @Test
    public void testUpdateCart()
    {
        ShoppingCart testCart = ShoppingCart.getInstance();
        Coffee testCoffee = new Coffee();

        testCoffee.setDrinkType(Coffee.LATTE);  //3.75
        testCoffee.setSize(Coffee.LARGE);
        testCoffee.setWhippedCream(true);       //.75

        testCart.add(testCoffee);
        double expected = 4.50;
        double actual = testCart.total();

        assertEquals(expected, actual, 0);

        testCoffee.setDrinkType(Coffee.HOT_CHOCOLATE);  //2.50
        testCoffee.setWhippedCream(false);

        testCart.updateCartItem(testCoffee);

        expected = 2.50;
        actual = testCart.total();

        assertEquals(expected, actual, 0);

    }

    @Test
    public void testCloneCoffee()
    {
        Coffee testCoffee = new Coffee();
        testCoffee.setSize(Coffee.SMALL);
        testCoffee.setDrinkType(Coffee.SULAWESI);
        testCoffee.setVanillaShots(1);
        testCoffee.setWhippedCream(true);
        testCoffee.setEspressoShots(2);
        testCoffee.setCaramelShots(3);
        testCoffee.setChocolateShots(4);

        Coffee cloneCoffee = testCoffee.cloneCoffee();

        assertEquals(testCoffee.cost(), cloneCoffee.cost(), 0);
        assertEquals(testCoffee.getSize(), cloneCoffee.getSize(), 0);
        assertEquals(testCoffee.getDrinkType(), cloneCoffee.getDrinkType(), 0);
        assertEquals(testCoffee.getVanillaShots(), cloneCoffee.getVanillaShots(), 0);
        assertEquals(testCoffee.getEspressoShots(), cloneCoffee.getEspressoShots(), 0);
        assertEquals(testCoffee.getCaramelShots(), cloneCoffee.getCaramelShots(), 0);
        assertEquals(testCoffee.getChocolateShots(), cloneCoffee.getChocolateShots(), 0);
        assertTrue(testCoffee.getWhippedCream() == cloneCoffee.getWhippedCream());


    }

    @Test
    public void testDefaultCoffee()
    {
        Coffee testCoffee = new Coffee();

        String expected = "Unknown Beverage";
        String actual = testCoffee.getDescription();

        assertTrue(actual.equals(expected));
    }

    /*
        Things to make tests for:
        -------------------------

        server communication
        coffee made is the coffee wanted
        coffee is placed in cart
        cost calculated correctly
        saved/removed from DB correctly
        cart updates changes


     */


}