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

    private String name;

    private String description;

    private String imageUrl;

    public RBeer() {
        this.id = 1;
        this.name = "";
        this.description = "";
        this.imageUrl = "";
    }

    public RBeer(long id, String name, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
