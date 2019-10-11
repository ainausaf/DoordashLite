package com.example.doordashlite;

import android.app.Application;
import android.content.Context;

import com.example.doordashlite.dagger.AppComponent;
import com.example.doordashlite.dagger.AppModule;
import com.example.doordashlite.dagger.DaggerAppComponent;
import com.example.doordashlite.retrofit.RetrofitModule;

public class DoordashliteApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .retrofitModule(new RetrofitModule())
                .build();
    }

    public AppComponent getApplicationComponent(){
        return appComponent;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
