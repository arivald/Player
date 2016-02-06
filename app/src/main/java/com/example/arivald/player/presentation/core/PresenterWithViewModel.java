package com.example.arivald.player.presentation.core;

import android.support.annotation.NonNull;

/**
 * Interface for Presenter's that have a ViewModel.
 *
 * Created by Arivald on 2016-02-01.
 */
public interface PresenterWithViewModel<VM extends ViewModel>  {

    @NonNull
    VM getViewModel();
}
