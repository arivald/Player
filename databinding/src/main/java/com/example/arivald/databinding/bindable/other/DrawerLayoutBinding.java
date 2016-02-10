package com.example.arivald.databinding.bindable.other;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.os.Parcel;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.arivald.databinding.R;
import com.example.arivald.databinding.bindable.core.BaseBindable;

/**
 * DrawerLayout binding.
 * Takes care of open/close both drawers, and handles ActionBarDrawerToggle creation and Toolbar.
 * Created by lplominski on 2016-02-08.
 */
public class DrawerLayoutBinding extends BaseBindable {

    boolean isDrawerOpen = false;
    boolean isSecondaryDrawerOpen = false;


    public boolean isDrawerOpen() {
        return isDrawerOpen;
    }

    public void openDrawer() {
        isDrawerOpen = true;
        notifyChange();
    }

    public void closeDrawer() {
        isDrawerOpen = false;
        notifyChange();
    }

    public boolean isSecondaryDrawerOpen() {
        return isSecondaryDrawerOpen;
    }

    public void openSecondaryDrawer() {
        isSecondaryDrawerOpen = true;
        notifyChange();
    }

    public void closeSecondaryDrawer() {
        isSecondaryDrawerOpen = false;
        notifyChange();
    }


    ///////////////////////////////////////////////////////////
    // BaseBindable

    final int PRIMARY_OPEN = 0x01;
    final int SECONDARY_OPEN = 0x02;

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        int value = (isDrawerOpen ? PRIMARY_OPEN : 0) | (isSecondaryDrawerOpen ? SECONDARY_OPEN : 0);
        dest.writeInt(value);
    }

    @Override
    public void readFromParcel(@NonNull Parcel in) {
        int value = in.readInt();
        isDrawerOpen = (value & PRIMARY_OPEN) == PRIMARY_OPEN;
        isSecondaryDrawerOpen = (value & SECONDARY_OPEN) == SECONDARY_OPEN;
        notifyChange();
    }

    ///////////////////////////////////////////////////////////
    // databinding

    static void syncBindingToView(@NonNull final DrawerLayout view, @NonNull final DrawerLayoutBinding drawerLayoutBinding) {
        drawerLayoutBinding.isDrawerOpen = view.isDrawerOpen(GravityCompat.START);
        drawerLayoutBinding.isSecondaryDrawerOpen = view.isDrawerOpen(GravityCompat.END);
    }

    static void syncViewToBinding(@NonNull final DrawerLayout view, @NonNull final DrawerLayoutBinding drawerLayoutBinding) {
        if (view.isDrawerOpen(GravityCompat.START)) {
            if (!drawerLayoutBinding.isDrawerOpen) {
                view.closeDrawer(GravityCompat.START);
            }
        } else {
            if (drawerLayoutBinding.isDrawerOpen) {
                view.openDrawer(GravityCompat.START);
            }
        }

        if (view.isDrawerOpen(GravityCompat.END)) {
            if (!drawerLayoutBinding.isSecondaryDrawerOpen) {
                view.closeDrawer(GravityCompat.END);
            }
        } else {
            if (drawerLayoutBinding.isSecondaryDrawerOpen) {
                view.openDrawer(GravityCompat.END);
            }
        }
    }

    @BindingAdapter({"app:binding"})
    public static void bindDrawerLayoutNoToolbar(@NonNull final DrawerLayout view,
                                                 @NonNull final DrawerLayoutBinding drawerLayoutBinding) {

        //no toolbar, simpler listener
        DrawerLayout.DrawerListener listener = (DrawerLayout.DrawerListener) view.getTag(R.id.DrawerLayout_DrawerListener);
        if (listener == null) {
            listener = new DrawerLayout.DrawerListener() {

                @Override
                public void onDrawerSlide(View drawerView, float slideOffset) {
                }

                @Override
                public void onDrawerOpened(View drawerView) {
                    syncBindingToView(view, drawerLayoutBinding);
                }

                @Override
                public void onDrawerClosed(View drawerView) {
                    syncBindingToView(view, drawerLayoutBinding);
                }

                @Override
                public void onDrawerStateChanged(int newState) {
                }
            };
            view.setTag(R.id.DrawerLayout_DrawerListener, listener);
            view.setDrawerListener(listener);
        }

        syncViewToBinding(view, drawerLayoutBinding);
    }

    // with toolbar

    @BindingAdapter({"app:binding", "app:toolbar"})
    public static void bindDrawerLayoutWithToolbar2(@NonNull final DrawerLayout view,
                                         @NonNull final DrawerLayoutBinding drawerLayoutBinding,
                                         @IdRes final int toolbarId) {

        bindDrawerLayoutWithToolbar(view, drawerLayoutBinding, toolbarId, 0, 0);
    }


    @BindingAdapter({"app:binding", "app:toolbar", "app:openDrawerContentDesc"})
    public static void bindDrawerLayoutWithToolbar3(@NonNull final DrawerLayout view,
                                         @NonNull final DrawerLayoutBinding drawerLayoutBinding,
                                         @IdRes final int toolbarId,
                                         @StringRes final int openDrawerContentDesc) {

        bindDrawerLayoutWithToolbar(view, drawerLayoutBinding, toolbarId, openDrawerContentDesc, 0);
    }


    @BindingAdapter({"app:binding", "app:toolbar", "app:closeDrawerContentDesc"})
    public static void bindDrawerLayoutWithToolbar4(@NonNull final DrawerLayout view,
                                         @NonNull final DrawerLayoutBinding drawerLayoutBinding,
                                         @IdRes final int toolbarId,
                                         @StringRes final int closeDrawerContentDesc) {

        bindDrawerLayoutWithToolbar(view, drawerLayoutBinding, toolbarId, 0, closeDrawerContentDesc);
    }

    /**
     * Binding adapter, will be used when this is bound to the custom "app:binding" property on EditText.
     */
    @BindingAdapter({"app:binding", "app:toolbar", "app:openDrawerContentDesc", "app:closeDrawerContentDesc"})
    public static void bindDrawerLayoutWithToolbar(@NonNull final DrawerLayout view,
                                        @NonNull final DrawerLayoutBinding drawerLayoutBinding,
                                        @IdRes final int toolbarId,
                                        @StringRes int openDrawerContentDesc,
                                        @StringRes int closeDrawerContentDesc) {

        if (toolbarId == 0) {
            bindDrawerLayoutNoToolbar(view, drawerLayoutBinding);
            return;
        }

        ActionBarDrawerToggle toggle = (ActionBarDrawerToggle) view.getTag(R.id.ActionBarDrawerToggle);
        if (toggle == null) {
            Toolbar toolbar = (Toolbar) view.findViewById(toolbarId);
            if (toolbar == null) {
                bindDrawerLayoutNoToolbar(view, drawerLayoutBinding);
                return;
            }

            if (openDrawerContentDesc == 0) {
                openDrawerContentDesc = R.string.navigation_drawer_open;
            }
            if (closeDrawerContentDesc == 0) {
                closeDrawerContentDesc = R.string.navigation_drawer_close;
            }

            toggle = new ActionBarDrawerToggle(
                    (Activity) view.getContext(), view, toolbar,
                    openDrawerContentDesc, closeDrawerContentDesc) {

                @Override
                public void onDrawerOpened(View drawerView) {
                    super.onDrawerOpened(drawerView);
                    syncBindingToView(view, drawerLayoutBinding);
                }

                @Override
                public void onDrawerClosed(View drawerView) {
                    super.onDrawerClosed(drawerView);
                    syncBindingToView(view, drawerLayoutBinding);
                }

            };
            view.setTag(R.id.ActionBarDrawerToggle, toggle);
            view.setDrawerListener(toggle);
            toggle.syncState();
        }

        syncViewToBinding(view, drawerLayoutBinding);
        toggle.syncState();
    }


}
