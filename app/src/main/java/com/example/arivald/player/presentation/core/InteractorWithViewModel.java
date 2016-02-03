package com.example.arivald.player.presentation.core;

import android.support.annotation.NonNull;

/**
 * Interface for Interactor's that have a ViewModel.
 *
 * Created by Arivald on 2016-02-01.
 */
public interface InteractorWithViewModel<VM extends ViewModel>  {

    @NonNull
    VM getViewModel();
}
