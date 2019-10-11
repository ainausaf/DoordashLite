package com.example.doordashlite.restaurantsList;

import com.example.doordashlite.data.Repository;
import com.example.doordashlite.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @ActivityScope
    public MainActivityContract.View provideMainActivityView() {
        return this.mainActivity;
    }

    @Provides
    @ActivityScope
    public MainActivityContract.Presenter providePresenter(MainActivityContract.View view,
                                                           Repository repository) {
        return new MainActivityPresenter(view, repository);
    }
}
