package com.sunrise.android.risingsun.beverage;

import java.util.UUID;

/**
 * Created by dell on 11/26/2017.
 */

public class Coffee
{

    public static final int SMALL = 1;
    public static final int LARGE = 2;
    public static final String SIZE_SMALL = "16oz";
    public static final String SIZE_LARGE = "20oz";

    private UUID mId;
    protected boolean mIsFavorited;
    protected String mDescription = "Unknown Beverage";
    protected String mOrder = "Empty Order";
    protected String mTitle = "Default Coffee";
    protected int size;

    public Coffee()
    {
        this(UUID.randomUUID());
    }

    public Coffee(UUID id)
    {
        mId = id;
    }

    public void setTitle(String title)
    {
        mTitle = title;
    }

    public void setOrder(String order)
    {
        mOrder = order;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public UUID getId()
    {
        return mId;
    }

    public void setDescription(String description)
    {
        mDescription = description;
    }

    public String getDescription()
    {
        return mDescription;
    }

    public String getOrder()
    {
        return mOrder;
    }

    public double cost() {return 0;}

    public boolean isFavorited()
    {
        return mIsFavorited;
    }

    public void setFavorited(boolean favorited)
    {
        mIsFavorited = favorited;
    }
}
