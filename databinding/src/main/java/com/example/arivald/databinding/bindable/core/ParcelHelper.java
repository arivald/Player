package com.example.arivald.databinding.bindable.core;

import android.os.Parcel;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Small helper to make easier to write Parcelable build out of BaseBindable descendants.
 *
 * Created by Arivald on 2016-02-06.
 */
public final class ParcelHelper {

    public static Builder builder() {
        return new Builder();
    }

    public void writeToParcel(@NonNull Parcel dest, int flags) {
        for (BaseBindable bindable : mBindables) {
            bindable.writeToParcel(dest, flags);
        }
    }

    public void readFromParcel(@NonNull Parcel in) {
        for (BaseBindable bindable : mBindables) {
            bindable.readFromParcel(in);
        }
    }

    @NonNull
    final List<BaseBindable> mBindables;

    protected ParcelHelper(@NonNull List<BaseBindable> bindables) {
        mBindables = bindables;
    }

    public static final class Builder {
        @NonNull
        final List<BaseBindable> mBindables = new ArrayList<>();

        public Builder add(@NonNull BaseBindable bindable) {
            mBindables.add(bindable);
            return this;
        }

        public ParcelHelper build() {
            return new ParcelHelper(mBindables);
        }
    }

}
