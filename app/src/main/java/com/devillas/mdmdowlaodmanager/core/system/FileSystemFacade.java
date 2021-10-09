package com.devillas.mdmdowlaodmanager.core.system;

import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public interface FileSystemFacade {
    void seek(@NonNull FileOutputStream fout, long offset) throws IOException;

    void allocate(@NonNull FileDescriptor fd, long length) throws IOException;

    void closeQuietly(Closeable closeable);

    String makeFilename(@NonNull Uri dir
            , @NonNull String desiredFileName);

    void moveFile(@NonNull Uri srcDir,
                  @NonNull String srcFileName,
                  @NonNull Uri destDir,
                  @NonNull String desFileName,
                  boolean replace) throws IOException, FileAlreadyExistsException;

    void copyFile(@NonNull Uri srcDir,
                  @NonNull Uri destDir,
                  boolean truncateDesteFile) throws IOException;

    FileDescriptorWrapper getFD(@NonNull Uri path);

    String getExtensionSeparator();

    String appendExtension(@NonNull String fileName, @NonNull String mimeType);

    @Nullable
    String getDefaultDownloadPath();

    @Nullable
    String getUserDirPath();

    boolean deleteFile(@NonNull Uri path) throws FileNotFoundException;

    Uri getFileUri(@NonNull Uri dir,
                   @NonNull String fileName);

    Uri getFileUri(@NonNull String relativePath,
                   @NonNull Uri dir);

    Uri createFile(@NonNull Uri dir,
                   @NonNull String fileName,
                   boolean replace) throws IOException;

    long getDirAvailableBytes(@NonNull Uri dir);

    String getExtension(String fileName);

    boolean isValidFatFileName(String name);

    String buildValidFatFileName(String name);

    String getDirName(@NonNull Uri dir);

    long getFileSize(@NonNull Uri filePath);

    void truncate(@NonNull Uri filePath, long newSize) throws IOException;

    void takePermissions(@NonNull Uri path);

    String getDirPath(@NonNull Uri dir);

    boolean exists(@NonNull Uri filePath);


}
