package com.sunrise.android.risingsun;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
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
    private Button mRemoveFromFavorites;
    private RadioGroup mSizeRadio;
    private EditText mSpecialInstructionEditText;
    private Button mAddToCart;

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
        UUID coffeeId = (UUID) getArguments().getSerializable(ARG_COFFEE_ID);

        mCoffee = FavoriteList.get(getActivity()).getCoffee(coffeeId);
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
        View v = inflater.inflate(R.layout.fragment_cart, container, false);


        mTitleField = (TextView) v.findViewById(R.id.coffee_title_view);
        mDescriptionField = (TextView) v.findViewById(R.id.coffee_description_view);
        mTitleField.setText(mCoffee.getTitle());
        mDescriptionField.setText(mCoffee.getDescription());

        mSpecialInstructionEditText = (EditText) v.findViewById(R.id.instructions_edit_text);
        if (mCoffee.getSpecialInstructions() != null)
            mSpecialInstructionEditText.setText(mCoffee.getSpecialInstructions());

        mSizeRadio = (RadioGroup) v.findViewById(R.id.size_radio_group);
        if (mCoffee.getSize() == Coffee.LARGE)
            mSizeRadio.check(R.id.large_radio);

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





        return v;
    }



}
