package com.example.arivald.databinding.bindable.core;

import android.databinding.BaseObservable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;
import android.os.Parcel;
import android.support.annotation.NonNull;

/**
 * Base for all two-way binding value objects
 *
 * Created by Arivald on 2016-02-06.
 */
public abstract class BaseBindable extends BaseObservable {


    ///////////////////////////////////////////////////////////////////////////////
    // Parcel support

    public abstract void writeToParcel(@NonNull Parcel dest, int flags);
    public abstract void readFromParcel(@NonNull Parcel in);

}
