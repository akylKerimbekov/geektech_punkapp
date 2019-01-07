package com.geektech.punkapp.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Mapper<K, T> {

    public abstract K map(T source);

    public abstract T reverseMap(K source);

    public ArrayList map(List<T> sourceList){

        ArrayList targetList = new ArrayList<>();

        for( T source : sourceList ){

            targetList.add( map( source ) );

        }

        return targetList;

    }

    public ArrayList reversMap(List<K> sourceList){

        ArrayList targetList = new ArrayList<>();

        for( K source : sourceList ){

            targetList.add( reverseMap( source ) );

        }

        return targetList;

    }

}