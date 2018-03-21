package com.sunrise.android.risingsun;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sunrise.android.risingsun.Coffee;

import java.util.List;

/**
 * Created by dell on 11/26/2017.
 */

public class CoffeeListFragment extends Fragment
{

    private RecyclerView mCoffeeRecyclerView;
    private CoffeeAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);


    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.fragment_coffee_list, container, false);

        mCoffeeRecyclerView = (RecyclerView) view
                .findViewById(R.id.coffee_recycler_view);
        mCoffeeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        updateUI();
    }

    @Override
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
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }

    private void updateUI()
    {
        CoffeeShop coffeeShop = CoffeeShop.get(getActivity());
        List<Coffee> coffees = coffeeShop.getCoffees();

        if (mAdapter == null)
        {
            mAdapter = new CoffeeAdapter(coffees);
            mCoffeeRecyclerView.setAdapter(mAdapter);
        }
        else
        {
            mAdapter.setCoffees(coffees);
            mAdapter.notifyDataSetChanged();
        }

    }

    private class CoffeeHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private Coffee mCoffee;

        private TextView mTitleTextView;
        private TextView mDescriptionTextView;
        private TextView mPriceTextView;

        public CoffeeHolder(LayoutInflater inflater, ViewGroup parent)
        {
            super(inflater.inflate(R.layout.list_item_coffee, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.coffee_title);
            mDescriptionTextView = (TextView) itemView.findViewById(R.id.coffee_description);
            mPriceTextView = (TextView) itemView.findViewById(R.id.coffee_price);
        }

        public void bind(Coffee coffee)
        {
            mCoffee = coffee;
            mTitleTextView.setText(mCoffee.getTitle());

            mDescriptionTextView.setText(mCoffee.getDescription());
            mPriceTextView.setText("" + mCoffee.cost());
        }

        @Override
        public void onClick(View view)
        {

            Intent intent = CoffeePagerActivity.newIntent(getActivity(), mCoffee.getId());
            startActivity(intent);
        }
    }

    private class CoffeeAdapter extends RecyclerView.Adapter<CoffeeHolder>
    {
        private List<Coffee> mCoffees;

        public CoffeeAdapter(List<Coffee> coffees)
        {
            mCoffees = coffees;
        }


        @Override
        public CoffeeHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new CoffeeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(CoffeeHolder holder, int position)
        {
            Coffee coffee = mCoffees.get(position);
            holder.bind(coffee);
        }

        @Override
        public int getItemCount()
        {
            return mCoffees.size();
        }

        public void setCoffees(List<Coffee> coffees)
        {
            mCoffees = coffees;
        }
    }
}
