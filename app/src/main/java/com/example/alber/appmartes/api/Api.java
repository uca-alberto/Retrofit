package com.example.alber.appmartes.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alber on 19/3/2018.
 */

public class Api {
    private final static String URL ="https://apismercodo.herokuapp.com/api/";

    public static ApiInterface instance()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiInterface.class);
    }
}
