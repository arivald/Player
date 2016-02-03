package com.example.arivald.player.core.di.application;

import android.app.Application;

/**
 * The application.
 *
 * Todo add multidex
 * Created by Arivald on 2016-02-01.
 */
public class App extends Application {

    private ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();

    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

}
