package com.example.arivald.player.presentation.core;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.arivald.player.core.di.activity.ActivityModule;
import com.example.arivald.player.core.di.application.App;
import com.example.arivald.player.core.di.application.ApplicationComponent;

import javax.inject.Inject;

/**
 * base activity class, with extensions for the architecture.
 *
 * Created by Arivald on 2016-01-28.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    protected Navigator mNavigator;

    @NonNull
    protected <T extends ViewModel> T getViewModel() {
        if (mActivityInteractor instanceof InteractorWithViewModel) {
            //noinspection unchecked
            return (T) ((InteractorWithViewModel) mActivityInteractor).getViewModel();
        }
        throw new IllegalStateException("Interactor does not support ViewModel");
    }

    /////////////////////////////////////////////////////////
    // to be overridden

    @NonNull
    protected abstract ActivityInteractor createInteractor();

    /////////////////////////////////////////////////////////
    // implementation

    protected ActivityInteractor mActivityInteractor;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);

        mActivityInteractor = createInteractor();
        mActivityInteractor.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mActivityInteractor.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mActivityInteractor.onResume();
    }

    @Override
    protected void onPause() {
        mActivityInteractor.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        mActivityInteractor.onStop();
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mActivityInteractor.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (!mActivityInteractor.onActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onBackPressed() {
        if (!mActivityInteractor.onBackPressed()) {
            super.onBackPressed();
        }
    }

    //////////////////////////////////////////////////////////////////////
    /// Dependency injection

    protected ApplicationComponent getApplicationComponent() {
        return ((App)getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

}
