package com.example.doordashlite.restaurantsList;

import com.example.doordashlite.model.Example;

import java.util.List;

public interface MainActivityContract {

    public interface View{

        void getRestaurantsList(List<Example> restaurantsList);

        void showProgressBar(boolean isDisplayProgressBar);

        void showErrorMessage();

    }

    public interface Presenter{

        void onCreate();

        void getRestaurantsListData();

    }
}
