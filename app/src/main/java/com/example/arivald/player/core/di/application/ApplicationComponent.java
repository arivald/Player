package com.example.arivald.player.core.di.application;

import android.content.Context;

import com.example.arivald.player.presentation.core.BaseActivity;
import com.example.arivald.player.presentation.core.Navigator;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Dagger2 Application component
 *
 * Created by Arivald on 2016-02-01.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    BaseActivity inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.

    Context context();

    Navigator navigator();

}
