package com.geektech.punkapp.presentation.beerlist.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.geektech.punkapp.data.beer.model.Beer;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
public class BeerListViewHolder extends RecyclerView.ViewHolder {
    public BeerListViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    void onBind(Beer beer){
        //TODO: Display beer data in views
    }
}
