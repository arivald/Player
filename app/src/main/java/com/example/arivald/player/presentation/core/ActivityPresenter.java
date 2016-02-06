package com.example.arivald.player.presentation.core;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Interface to be implemented by all presenters that binds to the Activity.
 *
 * Created by Arivald on 2016-01-28.
 */
public interface ActivityPresenter {

    /**
     * Called from Activity onCreate(savedInstanceState)
     * @param savedInstanceState saved state bundle
     */
    void onCreate(@Nullable Bundle savedInstanceState);

    /**
     * Called from Activity onStart()
     */
    void onStart();

    /**
     * Called from Activity onResume()
     */
    void onResume();

    /**
     * Called from Activity onPause()
     */
    void onPause();

    /**
     * Called from Activity onStop()
     */
    void onStop();

    /**
     * Called from Activity onSaveInstanceState(outState);
     * @param outState save state bundle
     */
    void onSaveInstanceState(@NonNull Bundle outState);


    /**
     * Called from Activity onActivityResult()
     */
    boolean onActivityResult(int requestCode, int resultCode, @Nullable Intent data);

    /**
     * Called from Activity onBackPressed()
     */
    boolean onBackPressed();
}
