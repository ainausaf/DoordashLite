package com.example.doordashlite.data;

import com.example.doordashlite.model.Example;

import java.util.List;

import rx.Observable;

public class Repository {

    private DataSource remoteDataSource;

    public Repository(DataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    //to get the restaurants List
    public Observable<List<Example>> getRestaurantsList() {

        Observable<List<Example>> observable;

        observable = remoteDataSource.getRestaurantsList();

        return observable;
    }
}
