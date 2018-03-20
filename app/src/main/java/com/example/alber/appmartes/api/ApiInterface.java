package com.example.alber.appmartes.api;

import com.example.alber.appmartes.models.MarketModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by alber on 19/3/2018.
 */

public interface ApiInterface {

    @GET("mercados")
    Call<List<MarketModel>> getMarkets();

    @POST("mercados")
    Call<MarketModel> postMarket(@Body MarketModel marketModel);

    @PUT("mercados/{id}")
    Call<MarketModel> update(@Path("id") String id,@Body MarketModel marketModel);

    @DELETE("mercados/{id}")
    Call<MarketModel> deleteMarket(@Path("id")String id);

}
