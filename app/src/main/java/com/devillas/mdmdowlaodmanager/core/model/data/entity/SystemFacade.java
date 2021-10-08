package com.devillas.mdmdowlaodmanager.core.model.data.entity;

import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

public interface SystemFacade {
    NetworkInfo getActiveNetworkInfo();

    NetworkCapabilities getNetworkCapabilities();

    boolean isActiveNetworkMetered();

    String getSystemUserAgent();

}
