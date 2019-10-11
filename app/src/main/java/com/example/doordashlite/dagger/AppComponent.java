package com.example.doordashlite.dagger;

import com.example.doordashlite.BaseActivity;
import com.example.doordashlite.data.Repository;
import com.example.doordashlite.restaurantsList.MainActivityModule;
import com.example.doordashlite.retrofit.RetrofitModule;
import com.example.doordashlite.scope.ApplicationScope;

import dagger.Component;

/**
 * Dagger App Component with Application Scope
 */
@ApplicationScope
@Component(modules = {AppModule.class, RetrofitModule.class, MainActivityModule.class})
public interface AppComponent {

    Repository getDataRepository();

    void inject(BaseActivity baseActivity);
}
