package com.example.arivald.player.presentation.hamburger.di;

import com.example.arivald.player.core.di.activity.ActivityComponent;
import com.example.arivald.player.core.di.activity.ActivityModule;
import com.example.arivald.player.core.di.activity.PerActivity;
import com.example.arivald.player.core.di.application.ApplicationComponent;
import com.example.arivald.player.presentation.hamburger.HamburgerActivity;
import com.example.arivald.player.presentation.hamburger.HamburgerPresenter;

import dagger.Component;

/**
 * Hamburger screen DI component.
 *
 * Created by Arivald on 2016-02-01.
 */
@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                ActivityModule.class,
                HamburgerModule.class
        }
)
public interface HamburgerComponent extends ActivityComponent {

    HamburgerActivity inject(HamburgerActivity hamburgerActivity);
    HamburgerPresenter inject(HamburgerPresenter hamburgerPresenter);

    //Exposed to sub-graphs.

    HamburgerPresenter getHamburgerPresenter();
}