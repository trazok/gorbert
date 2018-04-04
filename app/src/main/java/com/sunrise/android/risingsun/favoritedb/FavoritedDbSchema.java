package com.sunrise.android.risingsun.favoritedb;

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
            public static final String FAVORITED = "favorited";
            public static final String TYPE = "type";
            public static final String SIZE = "size";
            public static final String ESPRESSO = "espresso";
            public static final String CARAMEL = "caramel";
            public static final String CHOCOLATE = "chocolate";
            public static final String HAZELNUT = "hazelnut";
            public static final String VANILLA = "vanilla";
            public static final String WHIPPED = "whipped";
            public static final String ALMONDMILK = "almondmilk";
            public static final String INSTRUCTIONS = "instructions";

        }
    }
}
