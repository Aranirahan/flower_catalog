package com.example.aran.flower_catalog.controller;

import com.example.aran.flower_catalog.model.callback.BungaService;
import com.example.aran.flower_catalog.model.helper.Constans;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aran on 25/04/18.
 */

public class RestManager {
    private BungaService mBungaService;
    public BungaService getBungaService(){
        if(mBungaService == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constans.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mBungaService = retrofit.create(BungaService.class);
        }
        return mBungaService;
    }
}
