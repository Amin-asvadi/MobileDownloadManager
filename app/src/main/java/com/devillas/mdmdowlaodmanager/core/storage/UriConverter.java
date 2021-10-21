package com.devillas.mdmdowlaodmanager.core.storage;

import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.room.TypeConverter;

public class UriConverter {
    @TypeConverter
    public static Uri toUr(@NonNull String uriStr) {
        return Uri.parse(uriStr);
    }

    @TypeConverter
    public static String fromUri(@NonNull Uri uri) {
        return uri.toString();
    }
}
