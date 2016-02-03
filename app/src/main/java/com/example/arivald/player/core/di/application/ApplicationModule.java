package com.example.arivald.player.core.di.application;

import android.content.Context;

import com.example.arivald.player.presentation.core.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger2 Application module
 * <p/>
 * Created by Arivald on 2016-02-01.
 */
@Module
public class ApplicationModule {
    private final App application;

    public ApplicationModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    Navigator provideNavigator() {
        return new Navigator();
    }

}
