package com.example.arivald.player.presentation.core;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.example.arivald.player.presentation.hamburger.HamburgerActivity;

import javax.inject.Singleton;

/**
 * Navigator implementation
 *
 * Created by Arivald on 2016-02-01.
 */
@Singleton
public class Navigator {

    public void navigateUp() {

    }

    public void navigateUpToHamburger(@NonNull Activity activity) {
        //Hamburger activity uses the launchMode="singleTop"
        Intent intent = new Intent(activity, HamburgerActivity.class);
        activity.startActivity(intent);
    }
}
