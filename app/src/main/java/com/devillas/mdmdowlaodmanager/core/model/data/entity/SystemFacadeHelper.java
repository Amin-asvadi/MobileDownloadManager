package com.devillas.mdmdowlaodmanager.core.model.data.entity;

import android.content.Context;

import androidx.annotation.NonNull;

import com.devillas.mdmdowlaodmanager.core.system.FileSystemFacade;

public class SystemFacadeHelper {



    private static SystemFacade systemFacade;
private static FileSystemFacade fileSystemFacade;
    public synchronized static SystemFacade getSystemFacade(@NonNull Context appContext) {
        if (systemFacade == null)
            systemFacade = new SystemFacadeImpl(appContext);
        return systemFacade;
    }
    public synchronized static FileSystemFacade getFileSystemFacade(@NonNull Context appContext){
if (fileSystemFacade == null){
fileSystemFacade =  new
}

    }
}
