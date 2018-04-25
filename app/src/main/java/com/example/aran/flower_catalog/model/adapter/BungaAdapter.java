package com.example.aran.flower_catalog.model.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aran.flower_catalog.R;
import com.example.aran.flower_catalog.model.Bunga;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by aran on 25/04/18.
 */

public class BungaAdapter extends RecyclerView.Adapter<BungaAdapter.Holder> {
    private static final String TAG = BungaAdapter.class.getSimpleName();
    private List<Bunga> mBungas;
    public BungaAdapter() {
        mBungas = new ArrayList<>();
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View baris = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item ,parent,false);
        return new Holder(baris);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Bunga currBunga = mBungas.get(position);
        holder.mNama.setText(currBunga.getName());
        holder.mHarga.setText(Double.toString(currBunga.getPrice()));
        holder.mNama.setText(currBunga.getName());

        Picasso.get().load(currBunga.getPhoto()).into(holder.mPoto);

    }

    @Override
    public int getItemCount() {
        return mBungas.size();
    }

    public void addBunga(Bunga bunga) {
        Log.d(TAG, bunga.getPhoto());
        mBungas.add(bunga);
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder{
        private ImageView mPoto;
        private TextView mNama, mHarga;
        public Holder (View itemView){
            super(itemView);
            mPoto = itemView.findViewById(R.id.bunga_poto);
            mNama = itemView.findViewById(R.id.bunga_nama);
            mHarga = itemView.findViewById(R.id.bunga_harga);
        }
    }
}
