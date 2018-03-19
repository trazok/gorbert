package com.sunrise.android.risingsun;

/**
 * Created by dell on 12/13/2017.
 */

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.sunrise.android.risingsun.Coffee;

import java.util.List;


public class CartListFragment extends Fragment
{
    private RecyclerView mCartRecyclerView;
    private CartAdapter mAdapter;
    private Button mOrderButton;
    private TextView mTotalCostView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    public void placeOrder()
    {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_cart_list, container, false);

        mCartRecyclerView = (RecyclerView) view
                .findViewById(R.id.cart_recycler_view);
        mCartRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mOrderButton = (Button) view.findViewById(R.id.place_order_button);
        mOrderButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (ShoppingCart.getInstance().total() > 0) {
                    Toast.makeText(getActivity(), R.string.order_placed, Toast.LENGTH_SHORT).show();
                    placeOrder();
                }
                else
                {
                    Toast.makeText(getActivity(), R.string.cart_empty, Toast.LENGTH_SHORT).show();
                }
            }
        });
        mTotalCostView = (TextView) view.findViewById(R.id.order_total_view);
        mTotalCostView.setText("$" + ShoppingCart.getInstance().total());
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
        ShoppingCart cart = ShoppingCart.getInstance();
        List<Coffee> coffees = cart.getOrder();

        if (mAdapter == null)
        {
            mAdapter = new CartAdapter(coffees);
            mCartRecyclerView.setAdapter(mAdapter);
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
            Intent intent = CartPagerActivity.newIntent(getActivity(), mCoffee.getId());
            startActivity(intent);
        }
    }


    private class CartAdapter extends RecyclerView.Adapter<CoffeeHolder>
    {
        private List<Coffee> mCoffees;

        public CartAdapter(List<Coffee> coffees)
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