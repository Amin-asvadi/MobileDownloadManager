package com.devillas.mdmdowlaodmanager.core.system;

import androidx.annotation.NonNull;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;

public interface FileDescriptorWrapper extends Cloneable {
    FileDescriptor open(@NonNull String mode) throws FileNotFoundException;

}
