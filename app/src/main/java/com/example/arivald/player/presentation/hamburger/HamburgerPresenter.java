package com.example.arivald.player.presentation.hamburger;

import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;

import com.example.arivald.player.presentation.core.BaseActivityViewModelPresenter;

import javax.inject.Inject;

/**
 * HamburgerActivity Presenter
 * <p/>
 * Created by Arivald on 2016-02-03.
 */
public class HamburgerPresenter extends BaseActivityViewModelPresenter<HamburgerViewModel> {

    //todo shouldn't be in the Presenter, all Activity upates should be through viewmodel
    @Inject
    HamburgerActivity mActivity;

    @NonNull
    @Override
    protected HamburgerViewModel onCreateViewModel() {
        return new HamburgerViewModel();
    }

    @Override
    public boolean onBackPressed() {

        mViewModel.songName.set("changed name");

        //todo set it in view model, let model sync with activity
        if (mActivity.mBinding.drawer.isDrawerOpen(GravityCompat.START)) {
            mActivity.mBinding.drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        return false;
    }


}
