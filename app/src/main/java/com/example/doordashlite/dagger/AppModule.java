package com.example.doordashlite.dagger;

import com.example.doordashlite.DoordashliteApplication;
import com.example.doordashlite.retrofit.RetrofitModule;

import dagger.Module;

@Module(includes = RetrofitModule.class)
public class AppModule {

    private DoordashliteApplication baseApplication;

    public AppModule(DoordashliteApplication baseApplication) {
        this.baseApplication = baseApplication;
    }

}
