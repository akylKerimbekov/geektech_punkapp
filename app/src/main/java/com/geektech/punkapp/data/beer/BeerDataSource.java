package com.geektech.punkapp.data.beer;


import android.support.annotation.Nullable;

import com.geektech.punkapp.data.beer.model.Beer;

import java.util.ArrayList;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
public interface BeerDataSource {

    void getBeerList(BeerListCallback callback);

    void setBeerList(ArrayList<Beer> beers);

    @Nullable Beer getBeer(int id);

    interface BeerListCallback{
        void onSuccess(ArrayList<Beer> beers);
        void onError(Exception e);
    }
}