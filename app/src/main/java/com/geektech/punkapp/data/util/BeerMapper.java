package com.geektech.punkapp.data.util;

import com.geektech.punkapp.core.Mapper;
import com.geektech.punkapp.data.beer.local.model.RBeer;
import com.geektech.punkapp.data.beer.model.Beer;

public class BeerMapper extends Mapper<Beer, RBeer> {

    @Override
    public Beer map(RBeer source) {
        Beer beer = new Beer();
        beer.setId(source.getId());
        beer.setDescription(source.getDescription());
        beer.setName(source.getName());
        beer.setImageUrl(source.getImageUrl());
        return beer;
    }

    @Override
    public RBeer reverseMap(Beer source) {
        RBeer rBeer = new RBeer();
        rBeer.setId(source.getId());
        rBeer.setDescription(source.getDescription());
        rBeer.setName(source.getName());
        rBeer.setImageUrl(source.getImageUrl());
        return rBeer;
    }
}
