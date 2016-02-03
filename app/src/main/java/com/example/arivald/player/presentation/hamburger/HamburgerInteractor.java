package com.example.arivald.player.presentation.hamburger;

import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;

import com.example.arivald.player.presentation.core.BaseActivityViewModelInteractor;

import javax.inject.Inject;

/**
 * HamburgerActivity interactor
 * <p/>
 * Created by Arivald on 2016-02-03.
 */
public class HamburgerInteractor extends BaseActivityViewModelInteractor<HamburgerViewModel> {

    //todo shouldn't be in the interactor, all Activity upates should be through viewmodel
    @Inject
    HamburgerActivity mActivity;

    @NonNull
    @Override
    protected HamburgerViewModel onCreateViewModel() {
        return new HamburgerViewModel();
    }

    @Override
    public boolean onBackPressed() {
        //todo set it in view model, let model sync with activity
        if (mActivity.drawer.isDrawerOpen(GravityCompat.START)) {
            mActivity.drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        return false;
    }


}
