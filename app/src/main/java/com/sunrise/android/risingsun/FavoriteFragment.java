package com.sunrise.android.risingsun;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.UUID;

/**
 * Created by dell on 12/14/2017.
 */

public class FavoriteFragment extends Fragment
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
    private Button mRemoveFromFavoritesButton;
    private RadioGroup mSizeRadio;
    private EditText mSpecialInstructionsEditText;
    private Button mAddToCartButton;

    ShoppingCart mCart = ShoppingCart.getInstance();

    private int shotCount;




    public static FavoriteFragment newInstance(UUID coffeeId)
    {
        Bundle args = new Bundle();
        args.putSerializable(ARG_COFFEE_ID, coffeeId);

        FavoriteFragment fragment = new FavoriteFragment();

        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        UUID coffeeId = (UUID) getArguments().getSerializable(ARG_COFFEE_ID);

        mCoffee = FavoriteList.get(getActivity()).getCoffee(coffeeId);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_coffee_list, menu);
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

            case R.id.coffee_menu:
                Intent menu_intent = new Intent(getActivity(), CoffeeListActivity.class);
                startActivity(menu_intent);
                return true;

            case R.id.favorited_menu:
                Intent favorite_intent = new Intent(getActivity(), FavoriteListActivity.class);
                startActivity(favorite_intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }

    @Override
    public void onPause()
    {
        super.onPause();

        FavoriteList.get(getActivity())
                .updateCoffee(mCoffee);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_favorite, container, false);


        mTitleField = (TextView) v.findViewById(R.id.coffee_title_view);
        mDescriptionField = (TextView) v.findViewById(R.id.coffee_description_view);
        mTitleField.setText(mCoffee.getTitle());
        mDescriptionField.setText(mCoffee.getDescription());

        mSpecialInstructionsEditText = (EditText) v.findViewById(R.id.instructions_edit_text);
        if (mCoffee.getSpecialInstructions() != null)
            mSpecialInstructionsEditText.setText(mCoffee.getSpecialInstructions());

        mSizeRadio = (RadioGroup) v.findViewById(R.id.size_radio_group);
        if (mCoffee.getSize() == Coffee.LARGE)
            mSizeRadio.check(R.id.large_radio);
        else
            mSizeRadio.check(R.id.small_radio);

        mWhippedCheckBox = (CheckBox) v.findViewById(R.id.coffee_whipped);
        mWhippedCheckBox.setChecked(mCoffee.getWhippedCream());

        mAlmondMilkCheckBox = (CheckBox) v.findViewById(R.id.almond_milk_checkbox);
        mAlmondMilkCheckBox.setChecked(mCoffee.getAlmondMilk());

        mEspressoSpinner = (Spinner) v.findViewById(R.id.espresso_shots_spinner);
        mEspressoSpinner.setSelection(mCoffee.getEspressoShots());

        mCaramelSpinner = (Spinner) v.findViewById(R.id.caramel_shots_spinner);
        mCaramelSpinner.setSelection(mCoffee.getCaramelShots());

        mHazelnutSpinner = (Spinner) v.findViewById(R.id.hazelnut_shots_spinner);
        mHazelnutSpinner.setSelection(mCoffee.getHazelnutShots());

        mChocolateSpinner = (Spinner) v.findViewById(R.id.chocolate_shots_spinner);
        mChocolateSpinner.setSelection(mCoffee.getChocolateShots());

        mVanillaSpinner = (Spinner) v.findViewById(R.id.vanilla_shots_spinner);
        mVanillaSpinner.setSelection(mCoffee.getVanillaShots());

        mRemoveFromFavoritesButton = (Button) v.findViewById(R.id.remove_from_favorites_button);
        mRemoveFromFavoritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FavoriteList.get(getActivity()).remove(mCoffee.getId());

                Toast.makeText(getActivity(), R.string.favorite_removed, Toast.LENGTH_SHORT).show();

                Intent favorite_intent = new Intent(getActivity(), FavoriteListActivity.class);
                startActivity(favorite_intent);
            }
        });

        mAddToCartButton = (Button) v.findViewById(R.id.add_to_cart_button);
        mAddToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Coffee orderCoffee = mCoffee.cloneCoffee();
                //get coffee type

                //add radio size code
                if (mSizeRadio.getCheckedRadioButtonId() == R.id.large_radio)
                    orderCoffee.setSize(Coffee.LARGE);
                else
                    orderCoffee.setSize(Coffee.SMALL);

                orderCoffee.setAlmondMilk(mAlmondMilkCheckBox.isChecked());

                orderCoffee.setEspressoShots(mEspressoSpinner.getSelectedItemPosition());

                orderCoffee.setCaramelShots(mCaramelSpinner.getSelectedItemPosition());

                orderCoffee.setChocolateShots(mChocolateSpinner.getSelectedItemPosition());

                orderCoffee.setHazelnutShots(mHazelnutSpinner.getSelectedItemPosition());

                orderCoffee.setVanillaShots(mVanillaSpinner.getSelectedItemPosition());

                orderCoffee.setWhippedCream(mWhippedCheckBox.isChecked());

                orderCoffee.setSpecialInstructions(mSpecialInstructionsEditText.getText().toString());

                mCart.add(orderCoffee);

                Toast.makeText(getActivity(), R.string.item_added, Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }



}
