package com.example.arivald.databinding.bindable.string;

import android.support.annotation.Nullable;
import android.text.TextUtils;

/**
 * Nullable BindableString - value can be null.
 * Null will be passed to related TextViews.setText(), which translates to empty view.
 *
 * Created by Arivald on 2016-02-06.
 */
public class BindableNullableString extends BindableString {


    public BindableNullableString() {
        super();
    }

    public BindableNullableString(@Nullable String initialValue) {
        super(initialValue);
    }


    @Nullable
    public String get() {
        return mValue;
    }

    public void set(@Nullable String value) {
        if (!TextUtils.equals(mValue, value)) {
            mValue = value;
            notifyChange();
        }
    }

}
