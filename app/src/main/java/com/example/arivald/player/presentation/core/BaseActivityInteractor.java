package com.example.arivald.player.presentation.core;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.arivald.player.domain.external_api.presentation.Interactor;

/**
 * Base no-op implementation of ActivityInteractor.
 *
 * Created by Arivald on 2016-02-01.
 */
public class BaseActivityInteractor implements Interactor, ActivityInteractor {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

    }

    @Override
    public boolean onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        return false;
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

}
