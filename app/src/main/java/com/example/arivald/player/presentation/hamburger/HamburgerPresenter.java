package com.example.arivald.player.presentation.hamburger;

import android.support.annotation.NonNull;

import com.example.arivald.player.presentation.core.BaseActivityViewModelPresenter;

/**
 * HamburgerActivity Presenter
 * <p/>
 * Created by Arivald on 2016-02-03.
 */
public class HamburgerPresenter extends BaseActivityViewModelPresenter<HamburgerViewModel> {

    @NonNull
    @Override
    protected HamburgerViewModel onCreateViewModel() {
        return new HamburgerViewModel();
    }


    @Override
    public boolean onBackPressed() {

        if (mViewModel.drawer.isDrawerOpen()) {
            mViewModel.drawer.closeDrawer();
            return true;
        } else {
            mViewModel.drawer.openDrawer();
            return true;

        }
//        return false;
    }

    public void onMcPriorClick() {
        mViewModel.songName.set("onMcPriorClick");
    }

    public void onMcPlayClick() {
        mViewModel.songName.set("onMcPlayClick");
    }

    public void onMcNextClick() {
        mViewModel.drawer.closeDrawer();
        mViewModel.songName.set("onMcNextClick");
    }

    public void onMcStopClick() {
        mViewModel.songName.set("onMcStopClick");
    }

}
