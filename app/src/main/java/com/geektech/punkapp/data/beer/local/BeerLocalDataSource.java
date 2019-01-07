package com.geektech.punkapp.data.beer.local;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.geektech.punkapp.core.RealmBaseDataSource;
import com.geektech.punkapp.data.beer.BeerDataSource;
import com.geektech.punkapp.data.beer.local.model.RBeer;
import com.geektech.punkapp.data.beer.model.Beer;
import com.geektech.punkapp.data.util.BeerMapper;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
public class BeerLocalDataSource extends RealmBaseDataSource
        implements BeerDataSource {

    //region Static

    private static BeerDataSource INSTANCE;

    public static BeerDataSource getInstance(){
        if (INSTANCE == null)
            INSTANCE = new BeerLocalDataSource();

        return INSTANCE;
    }

    //endregion

    //region Contract

    @Override
    public void getBeerList(BeerListCallback callback) {
        //TODO: Implement fetch from DB
        Realm realm = null;
        BeerMapper mapper = new BeerMapper();

        try {
            realm = getRealm();

            RealmResults<RBeer> rBeers = realm.where(RBeer.class)
                    .findAll();

            ArrayList<Beer> beers = mapper.map(realm.copyFromRealm(rBeers));

            callback.onSuccess(beers);

        } catch (Exception e) {
            callback.onError(e);
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    @Override
    public void setBeerList(ArrayList<Beer> beers) {
        //TODO: Write beers into DB
        Realm realm = null;
        BeerMapper mapper = new BeerMapper();
        ArrayList<RBeer> rBeers = null;

        try {
            realm = getRealm();
            realm.beginTransaction();
            rBeers = mapper.reversMap(beers);
            for(RBeer beer : rBeers) {
                Log.d("ololo", beer.getName());
            }
            realm.copyToRealmOrUpdate(rBeers);
        } catch (Exception e) {
            Log.e("ololo", e.getMessage(), e);
        } finally {
            realm.commitTransaction();
            realm.close();
        }
    }

    @Nullable
    @Override
    public Beer getBeer(int id) {
        //TODO: Fetch target Beer info from db
        return null;
    }

    //endregion
}
