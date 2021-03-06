package com.example.arivald.databinding.bindable.string;

import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.adapters.ListenerUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.arivald.databinding.BR;
import com.example.arivald.databinding.R;

/**
 * Bindable String to use with EditText, also support the EditText.enabled property.
 *
 * Created by Arivald on 2016-02-08.
 */
public class EditTextBinding extends BindableNonNullString implements TextWatcher {

    protected boolean mEnabled = true;

    @Bindable
    public boolean getEnabled() {
        return mEnabled;
    }

    public void setEnabled(boolean value) {
        mEnabled = value;
        notifyChange();
    }


    public EditTextBinding() {
        super();
    }

    public EditTextBinding(@Nullable String initialValue) {
        super(initialValue);
    }

    public EditTextBinding(@Nullable String initialValue, @Nullable String defaultValue) {
        super(initialValue, defaultValue);
    }


    ///////////////////////////////////////////////////////////
    // databinding

    /**
     * Binding converter, will be used when this is bound to any other String property, like TextView:text.
     */
    @BindingConversion
    public static String convertEditTextBindingToString(@NonNull EditTextBinding editTextBinding) {
        return editTextBinding.get();
    }

    /**
     * Binding converter, will be used when this is bound to any other Boolean property, mapped to mEnabled.
     */
    @BindingConversion
    public static boolean convertEditTextBindingToBoolean(@NonNull EditTextBinding editTextBinding) {
        return editTextBinding.getEnabled();
    }

    /**
     * Binding adapter, will be used when this is bound to the custom "app:binding" property on EditText.
     */
    @BindingAdapter({"app:binding"})
    public static void bindEditText(@NonNull EditText view, @NonNull final EditTextBinding editTextBinding) {
        //make sure this editTextBinding is registered as TextChangedListener
        EditTextBinding oldBindable = ListenerUtil.trackListener(view, editTextBinding, R.id.onTextChangedListener);
        if (oldBindable != null) {
            view.removeTextChangedListener(oldBindable);
        }
        view.addTextChangedListener(editTextBinding);

        String newValue = editTextBinding.get();
        if (!TextUtils.equals(view.getText().toString(), newValue)) {
            view.setText(newValue);
        }

        view.setEnabled(editTextBinding.mEnabled);
    }
}
