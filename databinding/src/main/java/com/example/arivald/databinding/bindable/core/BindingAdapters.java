package com.example.arivald.databinding.bindable.core;

import android.databinding.BindingAdapter;
import android.databinding.adapters.ListenerUtil;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.arivald.databinding.R;

/**
 * General purpose adapters.
 *
 * Created by lplominski on 2016-02-08.
 */
public class BindingAdapters {

    /**
     * Binding adapter, converts the onClick handlers signature to parameter-less.
     * Ex. instead the onSomethingClick(View v) You can use onSomethingClick()
     */
    @BindingAdapter({"app:onClick"})
    public static void bindRunnableToOnClick(@NonNull View view, @NonNull final Runnable runnable) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runnable.run();
            }
        });
    }

    public interface OnClick {
        void onClick(int id);
    }

    /**
     * Binding adapter, converts the onClick handlers signature to onClick(int id).
     * It means that View is not passed, only its ID. This help to avoid Android classes in business
     * logic. View without ID will be reported as having View.NO_ID.
     * Ex. instead the onSomethingClick(View v) You can use onSomethingClick(int id)
     */
    @BindingAdapter({"app:onClickInt"})
    public static void bindRunnableToOnClick(@NonNull View view, @NonNull final BindingAdapters.OnClick onClick) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v != null) {
                    onClick.onClick(v.getId());
                }
            }
        });
    }

}
