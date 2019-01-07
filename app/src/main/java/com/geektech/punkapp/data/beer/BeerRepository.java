package com.geektech.punkapp.data.beer;

import android.support.annotation.Nullable;

import com.geektech.punkapp.data.beer.model.Beer;

import java.util.ArrayList;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
public class BeerRepository implements BeerDataSource {

    @Nullable
    private BeerDataSource mLocal;
    @Nullable
    private BeerDataSource mRemote;

    //region Constructor

    private BeerRepository(
            @Nullable BeerDataSource mLocal,
            @Nullable BeerDataSource mRemote) {
        this.mLocal = mLocal;
        this.mRemote = mRemote;
    }

    //endregion

    //region Static

    private static BeerDataSource INSTANCE;

    public static BeerDataSource getInstance(
            BeerDataSource local,
            BeerDataSource remote) {
        if (INSTANCE == null) {
            INSTANCE = new BeerRepository(local, remote);
        }
        return INSTANCE;
    }

    //endregion

    //region Contract

    @Override
    public void getBeerList(BeerListCallback callback) {
        //TODO: Call remote data source, and write response data to local data source
        if (mRemote != null) {
            mRemote.getBeerList(new BeerListCallback() {
                @Override
                public void onSuccess(ArrayList<Beer> beers) {
                    if(mLocal != null) {
                        mLocal.setBeerList(beers);
                    }
                    callback.onSuccess(beers);
                }

                @Override
                public void onError(Exception e) {
                    callback.onError(e);
                }
            });
        } else {
            callback.onError(new Exception("ololo remote is null"));
        }
    }

    @Nullable
    @Override
    public Beer getBeer(int id) {
        //TODO: Get beer from in memory cache or from local data source
        return null;
    }

    @Override
    public void setBeerList(ArrayList<Beer> beers) {
        //TODO: Send data to local data source
    }

    //endregion
}
