package com.devillas.mdmdowlaodmanager.core.system;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.FileDescriptor;
import java.io.IOException;

public interface SysCall {
void lseek(@NonNull FileDescriptor fd , long offset)throws IOException,UnsupportedOperationException;
void fallocate(@NonNull FileDescriptor fd,long length) throws IOException;
long availableBytes(@NonNull FileDescriptor fd )throws IOException;
}
