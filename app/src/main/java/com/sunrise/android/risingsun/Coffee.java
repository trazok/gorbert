package com.sunrise.android.risingsun;

import java.util.UUID;

/**
 * Created by dell on 11/26/2017.
 */

public class Coffee
{
    public static final int SULAWESI = 1;
    public static final int COLUMBIAN = 2;

    private UUID mId;
    private String mDescription;
    private boolean mFavorited;
    private String mTitle;

    private int mEspresso;
    private int mCaramel;
    private int mChocolate;
    private int mHazelnut;
    private int mVanilla;
    private boolean mWhipped;


    public Coffee(int type)
    {
        mDescription = "Black coffee";
        mId = UUID.randomUUID();
    }

    public String getTitle()
    {
        return mTitle;
    }

    public void setTitle(String title)
    {
        mTitle = title;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public void setFavorited(boolean favorited) {
        mFavorited = favorited;
    }

    public UUID getId() {
        return mId;
    }

    public String getDescription() {
        return mDescription;
    }

    public boolean isFavorited() {
        return mFavorited;
    }

    public int getEspresso() {
        return mEspresso;
    }

    public void setEspresso(int espresso) {
        mEspresso = espresso;
    }

    public int getCaramel() {
        return mCaramel;
    }

    public void setCaramel(int caramel) {
        mCaramel = caramel;
    }

    public int getChocolate() {
        return mChocolate;
    }

    public void setChocolate(int chocolate) {
        mChocolate = chocolate;
    }

    public int getHazelnut() {
        return mHazelnut;
    }

    public void setHazelnut(int hazelnut) {
        mHazelnut = hazelnut;
    }

    public int getVanilla() {
        return mVanilla;
    }

    public void setVanilla(int vanilla) {
        mVanilla = vanilla;
    }

    public boolean isWhipped() {
        return mWhipped;
    }

    public void setWhipped(boolean whipped) {
        mWhipped = whipped;
    }

}
