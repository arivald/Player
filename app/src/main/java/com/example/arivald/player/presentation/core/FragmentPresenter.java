package com.example.arivald.player.presentation.core;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Interface to be implemented by all presenters that binds to the Fragment.
 *
 * Created by Arivald on 2016-01-28.
 */
public interface FragmentPresenter {

    /**
     * Called from Fragment onCreate(savedInstanceState)
     * @param savedInstanceState saved state bundle
     */
    void onCreate(@Nullable Bundle savedInstanceState);

    /**
     * Called from Fragment onStart()
     */
    void onStart();

    /**
     * Called from Fragment onResume()
     */
    void onResume();

    /**
     * Called from Fragment onPause()
     */
    void onPause();

    /**
     * Called from Fragment onStop()
     */
    void onStop();

    /**
     * Called from Fragment onSaveInstanceState(outState);
     * @param outState save state bundle
     */
    void onSaveInstanceState(@NonNull Bundle outState);


    /**
     * Called from Fragment onFragmentResult()
     */
    boolean onFragmentResult(int requestCode, int resultCode, @NonNull Intent data);

    /**
     * Called from Fragment onBackPressed()
     */
    boolean onBackPressed();
}
