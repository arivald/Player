package com.example.arivald.player.core.di.activity;

import com.example.arivald.player.core.di.application.ApplicationComponent;
import com.example.arivald.player.presentation.core.BaseActivity;

import dagger.Component;

/**
 * Dagger2 Activity component
 * Created by Arivald on 2016-02-01.
 */
@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = ActivityModule.class
)
public interface ActivityComponent {
    //Exposed to sub-graphs.
    BaseActivity activity();
}