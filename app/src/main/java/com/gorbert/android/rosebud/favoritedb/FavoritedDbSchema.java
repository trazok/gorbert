package com.gorbert.android.rosebud.favoritedb;

/**
 * Created by dell on 12/14/2017.
 */

public class FavoritedDbSchema
{

    public static final class FavoriteTable
    {
        public static final String NAME = "favorites";


        public static final class Cols
        {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DESCRIPTION = "desciption";
            // public static final String CORDER = "corder";

        }
    }
}
