package com.gorbert.android.rosebud;

import android.support.v4.app.Fragment;

/**
 * Created by dell on 1/31/2018.
 */

public class ResultListActivity extends SingleFragmentActivity
{
    @Override
    protected Fragment createFragment()
    {
        return new ResultListFragment();
    }
}
