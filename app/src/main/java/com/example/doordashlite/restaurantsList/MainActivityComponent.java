package com.example.doordashlite.restaurantsList;

import com.example.doordashlite.dagger.AppComponent;
import com.example.doordashlite.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(
        dependencies = {AppComponent.class},
        modules = {MainActivityModule.class}
)

public interface MainActivityComponent {

    MainActivity inject (MainActivity mainActivity);
}
