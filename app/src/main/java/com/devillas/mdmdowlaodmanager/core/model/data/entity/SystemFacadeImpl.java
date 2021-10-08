package com.devillas.mdmdowlaodmanager.core.model.data.entity;

import android.content.Context;

import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

import androidx.annotation.NonNull;

import com.devillas.mdmdowlaodmanager.core.model.data.entity.SystemFacade;

public class SystemFacadeImpl implements SystemFacade {

    private Context context;

    public SystemFacadeImpl(@NonNull Context context) {
        this.context = context;
    }


    @Override
    public NetworkInfo getActiveNetworkInfo() {
        return null;
    }

    @Override
    public NetworkCapabilities getNetworkCapabilities() {
        return null;
    }

    @Override
    public boolean isActiveNetworkMetered() {
        return false;
    }

    @Override
    public String getSystemUserAgent() {
        return null;
    }
}
