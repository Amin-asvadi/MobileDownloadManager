package com.devillas.mdmdowlaodmanager.core.model.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Embedded;

public class InfoAndPices implements Parcelable {


@NonNull
@Embedded
public DownloadInfo info;


    protected InfoAndPices(Parcel in) {
    }

    public static final Creator<InfoAndPices> CREATOR = new Creator<InfoAndPices>() {
        @Override
        public InfoAndPices createFromParcel(Parcel in) {
            return new InfoAndPices(in);
        }

        @Override
        public InfoAndPices[] newArray(int size) {
            return new InfoAndPices[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
