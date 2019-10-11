package com.example.doordashlite.data;

import com.example.doordashlite.model.Example;
import com.example.doordashlite.retrofit.APIinterface;

import java.util.List;
import java.util.Map;
import rx.Observable;

public class DataSource {

    private APIinterface apiInterface;

    private Map<String, String> queryMap;

    public DataSource(APIinterface apiInterface) {
        this.apiInterface = apiInterface;

    }

    //network call to get the restaurants list
    Observable<List<Example>> getRestaurantsList() {

        return apiInterface.getRestaurantsList()
                .flatMap(Observable::just);
    }
}
