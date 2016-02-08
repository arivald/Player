package com.example.arivald.player.presentation.hamburger;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

import com.example.arivald.player.R;
import com.example.arivald.player.databinding.HamburgerActivityBinding;
import com.example.arivald.player.databinding.HamburgerNavHeaderBinding;
import com.example.arivald.player.presentation.core.ActivityPresenter;
import com.example.arivald.player.presentation.core.BaseActivity;
import com.example.arivald.player.presentation.hamburger.di.DaggerHamburgerComponent;
import com.example.arivald.player.presentation.hamburger.di.HamburgerComponent;
import com.example.arivald.player.presentation.hamburger.di.HamburgerModule;

import javax.inject.Inject;

public class HamburgerActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    HamburgerComponent mHamburgerComponent;

    @Inject
    HamburgerPresenter mHamburgerPresenter;

    HamburgerActivityBinding mBinding;
    HamburgerNavHeaderBinding mNavHeaderBinding;

    ActionBarDrawerToggle mActionBarDrawerToggle;


    @NonNull
    @Override
    protected ActivityPresenter createPresenter() {
        return mHamburgerPresenter;
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
        mBinding = DataBindingUtil.setContentView(this, R.layout.hamburger_activity);
        mBinding.setViewModel(this.<HamburgerViewModel>getViewModel());

        mNavHeaderBinding = DataBindingUtil.bind(mBinding.navigationView.getHeaderView(0));
        mNavHeaderBinding.setViewModel(this.<HamburgerViewModel>getViewModel());
        mNavHeaderBinding.setPresenter(mHamburgerPresenter);

        setSupportActionBar(mBinding.toolbar);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(
                this, mBinding.drawer, mBinding.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mBinding.drawer.setDrawerListener(mActionBarDrawerToggle);

        mBinding.navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mActionBarDrawerToggle.syncState();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hamburger, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //TODO pass to Presenter
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
        //TODO pass to Presenter
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

//        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
