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
        if (mActivityPresenter instanceof PresenterWithViewModel) {
            //noinspection unchecked
            return (T) ((PresenterWithViewModel) mActivityPresenter).getViewModel();
        }
        throw new IllegalStateException("Presenter does not support ViewModel");
    }

    /////////////////////////////////////////////////////////
    // to be overridden

    @NonNull
    protected abstract ActivityPresenter createPresenter();

    /////////////////////////////////////////////////////////
    // implementation

    protected ActivityPresenter mActivityPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);

        mActivityPresenter = createPresenter();
        mActivityPresenter.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mActivityPresenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mActivityPresenter.onResume();
    }

    @Override
    protected void onPause() {
        mActivityPresenter.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        mActivityPresenter.onStop();
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mActivityPresenter.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (!mActivityPresenter.onActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onBackPressed() {
        if (!mActivityPresenter.onBackPressed()) {
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
