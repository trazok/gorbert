package com.sunrise.android.risingsun;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by dell on 11/26/2017.
 */

public class CoffeeListFragment extends Fragment
{

    private RecyclerView mCoffeeRecyclerView;
    private CoffeeAdapter mAdapter;


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

    private void updateUI()
    {
        CoffeeShop coffeeShop = CoffeeShop.get(getActivity());
        List<Coffee> coffees = coffeeShop.getCoffees();

        mAdapter = new CoffeeAdapter(coffees);
        mCoffeeRecyclerView.setAdapter(mAdapter);

    }

    private class CoffeeHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private Coffee mCoffee;

        private TextView mTitleTextView;
        private TextView mDescriptionTextView;
        private ImageView mFavoritedImageView;

        public CoffeeHolder(LayoutInflater inflater, ViewGroup parent)
        {
            super(inflater.inflate(R.layout.list_item_coffee, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.coffee_title);
            mDescriptionTextView = (TextView) itemView.findViewById(R.id.coffee_description);
            mFavoritedImageView = (ImageView) itemView.findViewById(R.id.coffee_favorited);
        }

        public void bind(Coffee coffee)
        {
            mCoffee = coffee;
            mTitleTextView.setText(mCoffee.getTitle());

            mDescriptionTextView.setText(mCoffee.getDescription());
            mFavoritedImageView.setVisibility(coffee.isFavorited() ? View.VISIBLE : View.GONE);
        }

        @Override
        public void onClick(View view)
        {
            Intent intent = new Intent(getActivity(), CoffeeActivity.class);
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
    }
}
