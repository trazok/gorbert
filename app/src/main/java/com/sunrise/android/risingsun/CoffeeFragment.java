package com.sunrise.android.risingsun;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.sunrise.android.risingsun.beverage.Coffee;

import org.w3c.dom.Text;

import java.util.UUID;

/**
 * Created by dell on 11/26/2017.
 */

public class CoffeeFragment extends Fragment
{
    private static final String ARG_COFFEE_ID = "coffee_id";

    private Coffee mCoffee;
    private TextView mTitleField;
    private TextView mDescriptionField;
    private CheckBox mWhippedCheckBox;
    private Spinner mEspressoSpinner;
    private Spinner mCaramelSpinner;
    private Spinner mChocolateSpinner;

    public static CoffeeFragment newInstance(UUID coffeeId)
    {
        Bundle args = new Bundle();
        args.putSerializable(ARG_COFFEE_ID, coffeeId);

        CoffeeFragment fragment = new CoffeeFragment();

        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        UUID coffeeId = (UUID) getArguments().getSerializable(ARG_COFFEE_ID);

        mCoffee = CoffeeShop.get(getActivity()).getCoffee(coffeeId);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_coffee, container, false);

        mTitleField = (TextView) v.findViewById(R.id.coffee_title_view);
        mDescriptionField = (TextView) v.findViewById(R.id.coffee_description_view);
        mTitleField.setText(mCoffee.getTitle());
        mDescriptionField.setText(mCoffee.getDescription());

        mWhippedCheckBox = (CheckBox) v.findViewById(R.id.coffee_whipped);
        mWhippedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked)
            {
                //add whipped function;
            }
        });

        mEspressoSpinner = (Spinner) v.findViewById(R.id.espresso_shots_spinner);


        return v;
    }
}
