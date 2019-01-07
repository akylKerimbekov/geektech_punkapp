package com.geektech.punkapp.data.beer.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
public class Beer {
    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("image_url")
    private String imageUrl;

    //region Constructors

    public Beer() {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }


    //endregion

    //region Getters/Setters

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

    //endregion
}
