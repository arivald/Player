package com.example.arivald.databinding.bindable.string;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.example.arivald.databinding.R;
import com.example.arivald.databinding.bindable.core.BaseBindable;

/**
 * An Bindable that holds String, and can be bound to EditText as TextWatcher,
 * just use the "app:binding" attribute on EditText or its descendant.
 * Note that if You use "app:binding", there is no need to bind the "android:text", it will
 * be handled anyway.
 *
 * Created by Arivald on 2016-02-06.
 */
public abstract class BindableString extends BaseBindable implements TextWatcher {

    protected String mValue;

    public abstract String get();

    public abstract void set(String value);

    public BindableString() {
        mValue = "";
    }

    public BindableString(@Nullable String initialValue) {
        mValue = initialValue;
    }

    ///////////////////////////////////////////////////////////
    // TextWatcher

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public void afterTextChanged(Editable s) {
        set(s.toString());
    }

    ///////////////////////////////////////////////////////////
    // BaseBindable

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(mValue);
    }

    @Override
    public void readFromParcel(@NonNull Parcel in){
        mValue = in.readString();
        notifyChange();
    }

    ///////////////////////////////////////////////////////////
    // databinding

    @BindingConversion
    public static String convertBindableStringToString(@NonNull BindableString bindableString) {
        return bindableString.get();
    }

    @BindingAdapter({"app:binding"})
    public static void bindEditText(@NonNull EditText view, @NonNull final BindableString bindableString) {
        //make sure this bindableString is registered as TextChangedListener
        BindableString oldBindable = (BindableString) view.getTag(R.id.bound_bindable);
        if (oldBindable != bindableString) {
            if (oldBindable != null) {
                view.removeTextChangedListener(oldBindable);
            }

            view.setTag(R.id.bound_bindable, bindableString);
            view.addTextChangedListener(bindableString);
        }

        String newValue = bindableString.get();
        if (!view.getText().toString().equals(newValue)) {
            view.setText(newValue);
        }
    }

}
