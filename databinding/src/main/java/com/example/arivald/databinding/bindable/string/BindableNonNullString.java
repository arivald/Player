package com.example.arivald.databinding.bindable.string;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

/**
 * Non-null BindableString - value can't be null.
 *
 * Created by Arivald on 2016-02-06.
 */
public class BindableNonNullString extends BindableString {

    @NonNull
    protected String mDefaultValue = "";

    public BindableNonNullString() {
        super();
    }

    public BindableNonNullString(@Nullable String initialValue) {
        super(initialValue);
    }

    public BindableNonNullString(@Nullable String initialValue, @Nullable String defaultValue) {
        super();
        mDefaultValue = defaultValue == null ? "" : defaultValue;
        set(initialValue);
    }

    @NonNull
    public String get() {
        return nonNull(mValue);
    }

    public void set(@Nullable String value) {
        value = nonNull(value);
        if (!TextUtils.equals(mValue, value)) {
            mValue = value;
            notifyChange();
        }
    }

    @NonNull
    protected String nonNull(@Nullable String value) {
        return value == null ? mDefaultValue : value;
    }

}
