package com.example.aran.flower_catalog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.aran.flower_catalog.controller.RestManager;
import com.example.aran.flower_catalog.model.Bunga;
import com.example.aran.flower_catalog.model.adapter.BungaAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecycleView;
    private RestManager mManager;
    private BungaAdapter mBungaAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();

        mManager = new RestManager();
        Call<List<Bunga>> listCall = mManager.getBungaService().getSemuaBunga();
        listCall.enqueue(new Callback<List<Bunga>>() {
            @Override
            public void onResponse(Call<List<Bunga>> call, Response<List<Bunga>> response) {
                if(response.isSuccessful()){
                    List<Bunga> bungaList = response.body();
                    for(int i = 0; i<bungaList.size(); i++){
                        Bunga bunga = bungaList.get(i);
                        mBungaAdapter.addBunga(bunga);
                    }
                }else {
                    int sc = response.code();
                    switch (sc){

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Bunga>> call, Throwable t) {

            }
        });

    }

    private void configView() {
        mRecycleView = findViewById(R.id.rv_bunga);
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecycleView.setLayoutManager(new LinearLayoutManager(getApplicationContext()
                ,LinearLayoutManager.VERTICAL, false));
        //mRecycleView.setAdapter(new BungaAdapter());
        mBungaAdapter = new BungaAdapter();
        mRecycleView.setAdapter(mBungaAdapter);
    }
}
