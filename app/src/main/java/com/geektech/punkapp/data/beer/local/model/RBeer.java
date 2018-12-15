package com.geektech.punkapp.data.beer.local.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
//TODO: Add other fields
public class RBeer extends RealmObject {
    @PrimaryKey
    private long id;

}
