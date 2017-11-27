package com.sunrise.android.risingsun;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

/**
 * Created by dell on 11/26/2017.
 */

public class CoffeeFragment extends Fragment
{
    private Coffee mCoffee;
    private CheckBox mWhippedCheckBox;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mCoffee = new Coffee(Coffee.COLUMBIAN);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_coffee, container, false);

        mWhippedCheckBox = (CheckBox) v.findViewById(R.id.coffee_whipped);
        mWhippedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked)
            {
                mCoffee.setWhipped(isChecked);
            }
        });

        return v;
    }
}
