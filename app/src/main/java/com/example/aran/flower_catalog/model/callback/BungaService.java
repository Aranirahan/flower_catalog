package com.example.aran.flower_catalog.model.callback;

import com.example.aran.flower_catalog.model.Bunga;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aran on 25/04/18.
 */

public interface BungaService {
    @GET("/feeds/flowers.json")
    Call<List<Bunga>> getSemuaBunga();
}
