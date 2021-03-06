package com.example.arivald.player.presentation.hamburger;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.example.arivald.databinding.bindable.core.ParcelHelper;
import com.example.arivald.databinding.bindable.string.EditTextBinding;
import com.example.arivald.player.presentation.core.ViewModel;

/**
 * A ViewModel for the HamburgerActivity
 * <p/>
 * Created by Arivald on 2016-02-03.
 */
public class HamburgerViewModel implements ViewModel {

    public final EditTextBinding songName = new EditTextBinding(null, "default value");
    public final EditTextBinding songPath = new EditTextBinding("initial value");


    final ParcelHelper parcelHelper = ParcelHelper.builder()
            .add(songName)
            .add(songPath)
            .build();


    /////////////////////////////////////////////////
    // Parcelable

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        parcelHelper.writeToParcel(dest, flags);
    }

    public static final Parcelable.Creator<HamburgerViewModel> CREATOR = new Parcelable.Creator<HamburgerViewModel>() {
        public HamburgerViewModel createFromParcel(Parcel in) {
            HamburgerViewModel hamburgerViewModel = new HamburgerViewModel();
            hamburgerViewModel.parcelHelper.readFromParcel(in);
            return hamburgerViewModel;
        }

        public HamburgerViewModel[] newArray(int size) {
            return new HamburgerViewModel[size];
        }
    };

}
