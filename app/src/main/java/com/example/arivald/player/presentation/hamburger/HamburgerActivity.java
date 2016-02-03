package com.example.arivald.player.presentation.hamburger;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.arivald.player.R;
import com.example.arivald.player.presentation.core.ActivityInteractor;
import com.example.arivald.player.presentation.core.BaseActivity;
import com.example.arivald.player.presentation.core.BaseActivityInteractor;
import com.example.arivald.player.presentation.hamburger.di.DaggerHamburgerComponent;
import com.example.arivald.player.presentation.hamburger.di.HamburgerComponent;
import com.example.arivald.player.presentation.hamburger.di.HamburgerModule;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HamburgerActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    HamburgerComponent mHamburgerComponent;

    @Inject
    HamburgerInteractor mHamburgerInteractor;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.drawer_layout)
    DrawerLayout drawer;

    @Bind(R.id.nav_view)
    NavigationView navigationView;

    //todo handle those by google data binding?
//    @Bind(R.id.nav_header_song_title)
//    TextView navigationSongTitle;
//
//    @Bind(R.id.nav_header_song_path)
//    TextView navigationSongPath;
//
//    @Bind(R.id.nav_header_mc_prior)
//    TextView navigationPriorSong;
//
//    @Bind(R.id.nav_header_mc_play)
//    TextView navigationPlayPauseSong;
//
//    @Bind(R.id.nav_header_mc_next)
//    TextView navigationNextSong;
//
//    @Bind(R.id.nav_header_mc_stop)
//    TextView navigationStopPlaying;


    @NonNull
    @Override
    protected ActivityInteractor createInteractor() {
        return mHamburgerInteractor;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DI
        mHamburgerComponent = DaggerHamburgerComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .hamburgerModule(new HamburgerModule())
                .build();
        mHamburgerComponent.inject(this);

        super.onCreate(savedInstanceState);

        //Views
        setContentView(R.layout.hamburger_activity);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hamburger, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //TODO pass to interactor
        switch (item.getItemId()) {
            case R.id.action_settings:
                //TODO
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //TODO pass to interactor
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
