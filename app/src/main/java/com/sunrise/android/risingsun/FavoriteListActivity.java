package com.sunrise.android.risingsun;

import android.support.v4.app.Fragment;

/**
 * Created by dell on 12/14/2017.
 */

public class FavoriteListActivity extends SingleFragmentActivity
{

    @Override
    protected Fragment createFragment()
    {


        return new FavoriteListFragment();

    }

}
