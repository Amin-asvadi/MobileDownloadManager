package com.devillas.mdmdowlaodmanager.core.system;

import android.net.Uri;

import androidx.annotation.NonNull;

interface FsModuleResolver {
FsModule resolveFsByUri(@NonNull Uri uri);
}
