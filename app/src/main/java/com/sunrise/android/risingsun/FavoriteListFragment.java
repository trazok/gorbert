package com.sunrise.android.risingsun;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunrise.android.risingsun.Coffee;

import java.util.List;

/**
 * Created by dell on 12/14/2017.
 */

public class FavoriteListFragment extends Fragment
{


    private RecyclerView mFavoriteRecyclerView;
    private FavoriteAdapter mAdapter;

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
        View view = inflater.inflate(R.layout.fragment_favorite_list, container, false);

        mFavoriteRecyclerView = (RecyclerView) view
                .findViewById(R.id.favorite_recycler_view);
        mFavoriteRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

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

            case R.id.favorited_menu:
                return true;

            case R.id.coffee_menu:
                Intent menu_intent = new Intent(getActivity(), CoffeeListActivity.class);
                startActivity(menu_intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }

    private void updateUI()
    {
        FavoriteList favoriteList = FavoriteList.get(getActivity());
        List<Coffee> coffees = favoriteList.getCoffees();

        if (mAdapter == null)
        {
            mAdapter = new FavoriteAdapter(coffees);
            mFavoriteRecyclerView.setAdapter(mAdapter);
        }
        else
        {
            mAdapter.setCoffees(coffees);
            mAdapter.notifyDataSetChanged();
        }

    }

    private class FavoriteHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private Coffee mCoffee;

        private TextView mTitleTextView;
        private TextView mSummaryTextView;
        private TextView mPriceTextView;

        public FavoriteHolder(LayoutInflater inflater, ViewGroup parent)
        {
            super(inflater.inflate(R.layout.list_item_favorite, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.coffee_title);
            mSummaryTextView = (TextView) itemView.findViewById(R.id.coffee_summary);
            mPriceTextView = (TextView) itemView.findViewById(R.id.coffee_price);
        }

        public void bind(Coffee coffee)
        {
            mCoffee = coffee;
            mTitleTextView.setText(mCoffee.getTitle());

            mSummaryTextView.setText(mCoffee.toString());
            mPriceTextView.setText(String.format("$%.2f", mCoffee.cost()));
        }

        @Override
        public void onClick(View view)
        {
            Intent intent = FavoritePagerActivity.newIntent(getActivity(), mCoffee.getId());
            startActivity(intent);
        }
    }

    private class FavoriteAdapter extends RecyclerView.Adapter<FavoriteHolder>
    {
        private List<Coffee> mCoffees;

        public FavoriteAdapter(List<Coffee> coffees)
        {
            mCoffees = coffees;
        }


        @Override
        public FavoriteHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new FavoriteHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(FavoriteHolder holder, int position)
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
