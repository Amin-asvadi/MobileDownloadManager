package com.devillas.mdmdowlaodmanager.core.model.data.entity;

import android.content.Context;

import androidx.annotation.NonNull;

public class SystemFacadeHelper {

    private static SystemFacade systemFacade;

    public synchronized static SystemFacade getSystemFacade(@NonNull Context appContext) {
        if (systemFacade == null)
            systemFacade = new SystemFacadeImpl(appContext);
        return systemFacade;
    }
}
