package com.sunrise.android.risingsun;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by trazo on 4/11/2018.
 */
public class UITests {

    @Rule
    public ActivityTestRule<CoffeeListActivity> mActivityTestRule = new ActivityTestRule<CoffeeListActivity>(CoffeeListActivity.class);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testLaunchMainActivity()
    {

    }

    @Test
    public void testOpenCoffeeItem()
    {
        
    }

    /*
        UI tests to write:
        -------------------

        recycler view is created/populated
        clicking recycler item launches fragment
        swiping pages fragment
        clicking menu launches appropriate activity
        button clicks are functioning
        special instructions edit text stores instructions properly

     */


    @After
    public void tearDown() throws Exception {
    }


}