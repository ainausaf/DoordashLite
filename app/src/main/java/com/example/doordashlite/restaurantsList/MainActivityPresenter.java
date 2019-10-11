package com.example.doordashlite.restaurantsList;

import com.example.doordashlite.data.Repository;
import com.example.doordashlite.model.Example;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private Repository repository;


    private MainActivityContract.View view;

    public MainActivityPresenter(MainActivityContract.View view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void onCreate() {
        view.showProgressBar(true);
        getRestaurantsListData();
    }


    //service call is being made to retrieve the list of restaurants
    public void getRestaurantsListData() {
        final Observable<List<Example>> restaurantsListData = repository.getRestaurantsList();
        restaurantsListData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(restaurantsList -> {
                    view.getRestaurantsList(restaurantsList);
                    view.showProgressBar(false);
                }, throwable -> {
                    throwable.printStackTrace();
                    view.showErrorMessage();
                    view.showProgressBar(false);
                });
    }
}
