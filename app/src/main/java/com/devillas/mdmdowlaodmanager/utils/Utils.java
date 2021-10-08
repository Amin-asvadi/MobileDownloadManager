package com.devillas.mdmdowlaodmanager.utils;

import android.content.Context;
import android.content.res.Resources;

import androidx.annotation.NonNull;

public class Utils {


public static int getDefaultBatteryLowLevel(){
return Resources.getSystem().getInteger(
        Resources.getSystem().getIdentifier("config_lowBatteryWarningLevel", "integer", "android")
);
}

}
