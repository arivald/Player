package com.example.arivald.player.core.di.activity;

import com.example.arivald.player.presentation.core.BaseActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger2 Activity module.
 * <p/>
 * Uses the BaseActivity, bacause all activities in app are BaseActivity.
 * <p/>
 * Created by Arivald on 2016-02-01.
 */
@Module
public class ActivityModule {
    private final BaseActivity activity;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    BaseActivity activity() {
        return this.activity;
    }
}
