package com.example.arivald.databinding.bindable.other;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.adapters.ListenerUtil;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.arivald.databinding.R;
import com.example.arivald.databinding.bindable.core.BaseBindable;

/**
 * Created by lplominski on 2016-02-08.
 */
public class DrawerLayoutBinding extends BaseBindable implements DrawerLayout.DrawerListener {

    ///////////////////////////////////////////////////////////
    // BaseBindable

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        //TODO dest.writeString(mValue);
    }

    @Override
    public void readFromParcel(@NonNull Parcel in){
        //TODO mValue = in.readString();
        notifyChange();
    }

    ///////////////////////////////////////////////////////////////////////
    // DrawerLayout.DrawerListener

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }

    ///////////////////////////////////////////////////////////
    // databinding

    /**
     * Binding adapter, will be used when this is bound to the custom "app:binding" property on EditText.
     */
    @BindingAdapter({"app:binding"})
    public static void bindEditText(@NonNull DrawerLayout view, @NonNull final DrawerLayoutBinding drawerLayoutBinding) {

        view.setDrawerListener(drawerLayoutBinding);

//        //make sure this bindableString is registered as TextChangedListener
//        BindableString oldBindable = ListenerUtil.trackListener(view, bindableString, R.id.onTextChangedListener);
//        if (oldBindable != null) {
//            view.removeTextChangedListener(oldBindable);
//        }
//        view.addTextChangedListener(bindableString);
//
//        String newValue = bindableString.get();
//        if (!TextUtils.equals(view.getText().toString(), newValue)) {
//            view.setText(newValue);
//        }
    }

}
