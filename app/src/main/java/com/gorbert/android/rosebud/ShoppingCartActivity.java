package com.gorbert.android.rosebud;

import android.support.v4.app.Fragment;

/**
 * Created by dell on 12/13/2017.
 */

public class ShoppingCartActivity extends SingleFragmentActivity
{
    @Override
    protected Fragment createFragment()
    {


        return new CartListFragment();

    }
}