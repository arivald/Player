package com.example.arivald.player.presentation.core;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.arivald.player.domain.external_api.presentation.Interactor;

/**
 * Base implementation of ActivityInteractor with View model.
 * <p/>
 * Created by Arivald on 2016-02-01.
 */
public abstract class BaseActivityViewModelInteractor<VM extends ViewModel>
        extends BaseActivityInteractor
        implements InteractorWithViewModel<VM> {

    private static final String EXTRA_VIEW_MODEL = "BaseActivityViewModelInteractor.EXTRA_VIEW_MODEL";

    /**
     * The VievModel field.
     * Note that it is marked as @NonNull, it is possible in the very beginning of the lifecycle to
     * have it null, before the onCreate() is called.
     */
    @SuppressWarnings("ConstantConditions")
    @NonNull
    protected VM mViewModel = null;

    /////////////////////////////////////////////////////
    // to be overridden

    @NonNull
    protected abstract VM onCreateViewModel();


    /////////////////////////////////////////////////////
    // implementation

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(EXTRA_VIEW_MODEL, mViewModel);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        //if possible - restore the old model
        if (savedInstanceState != null) {
            //noinspection ConstantConditions
            mViewModel = savedInstanceState.getParcelable(EXTRA_VIEW_MODEL);
        }
        //otherwise make A new one.
        if (mViewModel == null) {
            mViewModel = onCreateViewModel();
        }
    }

    @NonNull
    @Override
    public VM getViewModel() {
        return mViewModel;
    }

}
