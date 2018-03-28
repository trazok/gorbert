package com.sunrise.android.risingsun;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



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
    private CheckBox mAlmondMilkCheckBox;
    private Spinner mEspressoSpinner;
    private Spinner mCaramelSpinner;
    private Spinner mChocolateSpinner;
    private Spinner mHazelnutSpinner;
    private Spinner mVanillaSpinner;
    private Button mAddToCart;
    private RadioGroup mSizeRadio;

    ShoppingCart mCart = ShoppingCart.getInstance();

    private int shotCount;




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
        setHasOptionsMenu(true);
        UUID coffeeId = (UUID) getArguments().getSerializable(ARG_COFFEE_ID);

        mCoffee = CoffeeShop.get(getActivity()).getCoffee(coffeeId);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.item_view_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.cart_menu:
                Intent cart_intent = new Intent(getActivity(), ShoppingCartActivity.class);
                startActivity(cart_intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }




    @Override
    public void onPause()
    {
        super.onPause();

        //CoffeeShop.get(getActivity()).updateCoffee(mCoffee);
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

        mSizeRadio = (RadioGroup) v.findViewById(R.id.size_radio_group);

        mWhippedCheckBox = (CheckBox) v.findViewById(R.id.coffee_whipped);
        mAlmondMilkCheckBox = (CheckBox) v.findViewById(R.id.almond_milk_checkbox);

        mEspressoSpinner = (Spinner) v.findViewById(R.id.espresso_shots_spinner);


        mCaramelSpinner = (Spinner) v.findViewById(R.id.caramel_shots_spinner);
        mHazelnutSpinner = (Spinner) v.findViewById(R.id.hazelnut_shots_spinner);
        mChocolateSpinner = (Spinner) v.findViewById(R.id.chocolate_shots_spinner);
        mVanillaSpinner = (Spinner) v.findViewById(R.id.vanilla_shots_spinner);

        mAddToCart = (Button) v.findViewById(R.id.add_to_cart_button);
        mAddToCart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                Coffee orderCoffee = mCoffee.cloneCoffee();
                //get coffee type

                //add radio size code
                if (mSizeRadio.getCheckedRadioButtonId() == R.id.large_radio)
                    orderCoffee.setSize(Coffee.LARGE);


                orderCoffee.setAlmondMilk(mAlmondMilkCheckBox.isChecked());

                orderCoffee.setEspressoShots(mEspressoSpinner.getSelectedItemPosition());

                orderCoffee.setCaramelShots(mCaramelSpinner.getSelectedItemPosition());

                orderCoffee.setChocolateShots(mChocolateSpinner.getSelectedItemPosition());

                orderCoffee.setHazelnutShots(mHazelnutSpinner.getSelectedItemPosition());

                orderCoffee.setVanillaShots(mVanillaSpinner.getSelectedItemPosition());

                orderCoffee.setWhippedCream(mWhippedCheckBox.isChecked());

                mCart.add(orderCoffee);
                Toast.makeText(getActivity(), R.string.item_added, Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }



}
