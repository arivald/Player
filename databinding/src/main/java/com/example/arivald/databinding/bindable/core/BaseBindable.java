package com.example.arivald.databinding.bindable.core;

import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;
import android.os.Parcel;
import android.support.annotation.NonNull;

/**
 * Base for all two-way binding value objects
 *
 * Created by Arivald on 2016-02-06.
 */
public abstract class BaseBindable implements Observable {

    ///////////////////////////////////////////////////////////////////////////////
    // property observing support

    private PropertyChangeRegistry mCallbacks;

    public synchronized void addOnPropertyChangedCallback(OnPropertyChangedCallback listener) {
        if (this.mCallbacks == null) {
            this.mCallbacks = new PropertyChangeRegistry();
        }

        this.mCallbacks.add(listener);
    }

    public synchronized void removeOnPropertyChangedCallback(OnPropertyChangedCallback listener) {
        if (this.mCallbacks != null) {
            this.mCallbacks.remove(listener);
        }
    }

    public synchronized void notifyChange() {
        if (this.mCallbacks != null) {
            this.mCallbacks.notifyCallbacks(this, 0, null);
        }
    }

    public synchronized void notifyPropertyChanged(int fieldId) {
        if (this.mCallbacks != null) {
            this.mCallbacks.notifyCallbacks(this, fieldId, null);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////
    // Parcel support

    public abstract void writeToParcel(@NonNull Parcel dest, int flags);
    public abstract void readFromParcel(@NonNull Parcel in);

}
