package com.example.doordashlite;

import com.example.doordashlite.data.Repository;
import com.example.doordashlite.model.Example;
import com.example.doordashlite.restaurantsList.MainActivityContract;
import com.example.doordashlite.restaurantsList.MainActivityPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import rx.Observable;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.schedulers.Schedulers;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainActivityPresenterTest {

    @Mock
    private MainActivityContract.View mockView;

    @Mock
    private Repository mockDataRepository;

    @Mock
    private List<Example> restaurantsData;

    @Mock
    private Example restaurant;

    private MainActivityContract.Presenter presenter;

    @Before
    public void setup() {
        presenter = new MainActivityPresenter(mockView, mockDataRepository);
        RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });
    }

    @Test
    public void getRestaurants_testCallback() {
        when(mockDataRepository.getRestaurantsList())
                .thenReturn(Observable.just(restaurantsData));

        presenter.getRestaurantsListData();

        verify(mockView).showProgressBar(true);
        verify(mockDataRepository).getRestaurantsList();

        verify(mockView).getRestaurantsList(restaurantsData);
        verify(mockView, times(1)).showProgressBar(false);
    }

}
