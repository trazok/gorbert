package com.sunrise.android.risingsun.database;

/**
 * Created by dell on 12/12/2017.
 */

public class CoffeeDbSchema
{
    public static final class CoffeeTable
    {
        public static final String NAME = "coffees";


        public static final class Cols
        {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DESCRIPTION = "desciption";
           // public static final String CORDER = "corder";
            public static final String FAVORITED = "favorited";

        }
    }
}
