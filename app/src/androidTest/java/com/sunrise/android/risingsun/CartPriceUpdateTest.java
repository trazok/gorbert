package com.sunrise.android.risingsun;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CartPriceUpdateTest {

    @Rule
    public ActivityTestRule<CoffeeListActivity> mActivityTestRule = new ActivityTestRule<>(CoffeeListActivity.class);

    @Test
    public void cartPriceUpdateTest() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.coffee_recycler_view),
                        childAtPosition(
                                withId(R.id.fragment_container),
                                0)));
        recyclerView.perform(actionOnItemAtPosition(3, click()));

        ViewInteraction appCompatCheckBox = onView(
                allOf(withId(R.id.coffee_whipped), withText("Whipped Cream"),
                        childAtPosition(
                                withParent(withId(R.id.coffee_view_pager)),
                                2),
                        isDisplayed()));
        appCompatCheckBox.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.favorited_menu), withContentDescription("Favorites"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.action_bar),
                                        1),
                                1),
                        isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction actionMenuItemView2 = onView(
                allOf(withId(R.id.coffee_menu), withContentDescription("Menu"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.action_bar),
                                        1),
                                0),
                        isDisplayed()));
        actionMenuItemView2.perform(click());

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.coffee_recycler_view),
                        childAtPosition(
                                withId(R.id.fragment_container),
                                0)));
        recyclerView2.perform(actionOnItemAtPosition(3, click()));

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.add_to_cart_button), withText("Add to cart"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                16)),
                                1),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction actionMenuItemView3 = onView(
                allOf(withId(R.id.cart_menu), withContentDescription("Shopping Cart"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.action_bar),
                                        2),
                                0),
                        isDisplayed()));
        actionMenuItemView3.perform(click());

        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.cart_recycler_view),
                        childAtPosition(
                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                0)));
        recyclerView3.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.remove_button), withText("Remove"),
                        childAtPosition(
                                withParent(withId(R.id.cart_view_pager)),
                                13),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.order_total_view), withText("$0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.fragment_container),
                                        0),
                                1),
                        isDisplayed()));
        textView.check(matches(withText("$0.00")));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
