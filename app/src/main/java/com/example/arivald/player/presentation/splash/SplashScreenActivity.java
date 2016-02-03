package com.example.arivald.player.presentation.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.arivald.player.presentation.hamburger.HamburgerActivity;

/**
 * The splash screen, first Activity when app is launched.
 * Important: it will be shown BEFORE the App object is initialized, without the content view, but
 * its onCreate will be called AFTER app is initialized. It is why the logo is implemented only
 * in Theme - because this information is extracted and processed way before tha App.onCreate();
 *
 * Because this activity is used before the App is created, it have to be basic AppCompatActivity,
 * not the BaseActivity, because BaseActivity may depend on the App is initialized.
 */
public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();

        //Hamburger activity uses the launchMode="singleTop"
        Intent intent = new Intent(this, HamburgerActivity.class);
        startActivity(intent);
        finish();
    }
}
