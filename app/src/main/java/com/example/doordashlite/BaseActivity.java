package com.example.doordashlite;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.doordashlite.dagger.AppComponent;

public class BaseActivity extends AppCompatActivity {

    protected AppComponent appComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDaggerComponent();
    }

    protected void initDaggerComponent() {

        if (appComponent == null) {
            appComponent = ((DoordashliteApplication) getApplication()).getApplicationComponent();
            appComponent.inject(this);
        }
    }


    @Override
    protected void onDestroy() {
        releaseDI();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        initDaggerComponent();
        super.onResume();
    }

    @Override
    protected void onPause() {
        releaseDI();
        super.onPause();
    }

    private void releaseDI() {
        appComponent = null;
    }
}
