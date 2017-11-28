package com.sunrise.android.risingsun;

import android.support.v4.app.Fragment;

/**
 * Created by dell on 11/26/2017.
 */

public class CoffeeListActivity extends SingleFragmentActivity
{
    @Override
    protected Fragment createFragment()
    {
        return new CoffeeListFragment();
    }
}
