package com.sunrise.android.risingsun;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class CoffeeActivity extends SingleFragmentActivity
{

    public static final String EXTRA_COFFEE_ID = "com.sunrise.android.risingsun.coffee_id";

    public static Intent newIntent(Context packageContext, UUID coffeeId)
    {
        Intent intent = new Intent(packageContext, CoffeeActivity.class);
        intent.putExtra(EXTRA_COFFEE_ID, coffeeId);

        return intent;
    }

    @Override
    protected Fragment createFragment()
    {
        return new CoffeeFragment();
    }
}
