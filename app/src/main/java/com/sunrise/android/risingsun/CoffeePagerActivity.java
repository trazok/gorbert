package com.sunrise.android.risingsun;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.sunrise.android.risingsun.Coffee;

import java.util.List;
import java.util.UUID;

/**
 * Created by dell on 12/4/2017.
 */

public class CoffeePagerActivity extends AppCompatActivity
{
    private static final String EXTRA_COFFEE_ID = "com.sunrise.android.risingsun.coffee_id";
    private ViewPager mViewPager;
    private List<Coffee> mCoffees;

    public static Intent newIntent(Context packageContext, UUID coffeeId)
    {
        Intent intent = new Intent(packageContext, CoffeePagerActivity.class);
        intent.putExtra(EXTRA_COFFEE_ID, coffeeId);

        return intent;
    }

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_pager);

        UUID coffeeId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_COFFEE_ID);

        mViewPager = (ViewPager) findViewById(R.id.coffee_view_pager);

        mCoffees = CoffeeShop.get(this).getCoffees();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager)
        {
            @Override
            public Fragment getItem(int position)
            {
                Coffee coffee = mCoffees.get(position);

                return CoffeeFragment.newInstance(coffee.getId());
            }

            @Override
            public int getCount()
            {
                return mCoffees.size();
            }
        });

        for (int i = 0; i < mCoffees.size(); i++)
        {
            if (mCoffees.get(i).getId().equals(coffeeId))
            {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
