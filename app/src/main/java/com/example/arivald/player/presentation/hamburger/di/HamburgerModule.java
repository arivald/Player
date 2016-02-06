package com.example.arivald.player.presentation.hamburger.di;

import com.example.arivald.player.core.di.activity.PerActivity;
import com.example.arivald.player.presentation.core.BaseActivity;
import com.example.arivald.player.presentation.hamburger.HamburgerActivity;
import com.example.arivald.player.presentation.hamburger.HamburgerPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Hamburger screen DI module.
 *
 * Created by Arivald on 2016-02-01.
 */
@Module
public class HamburgerModule {

    @Provides
    @PerActivity
    HamburgerPresenter provideHamburgerPresenter(HamburgerComponent hamburgerComponent) {
        return hamburgerComponent.inject(new HamburgerPresenter());
    }

    @Provides
    @PerActivity
    HamburgerActivity hamburgerActivity(BaseActivity baseActivity) {
        return HamburgerActivity.class.cast(baseActivity);
    }


}
