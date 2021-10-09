package com.devillas.mdmdowlaodmanager.core.system;

import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class FileSystemFacadeImpl implements FileSystemFacade {

    @SuppressWarnings("unused")
    private static final String TAG = FileSystemFacade.class.getSimpleName();

    private static final String EXTENSION_SEPARATOR = ".";
    /* The file copy buffer size (30 MB) */
    private static final long FILE_COPY_BUFFER_SIZE = 1024 * 1024 * 30;

    private SysCall sysCall;
    private FsModuleResolver fsModuleResolver;

    public FileSystemFacadeImpl(SysCall sysCall, FsModuleResolver fsResolver) {
        this.sysCall = sysCall;
        this.fsModuleResolver = fsResolver;
    }

    /*
     * See http://man7.org/linux/man-pages/man2/lseek.2.html
     */


    @Override
    public void seek(@NonNull FileOutputStream fout, long offset) throws IOException {
        try {
            sysCall.lseek(fout.getFD(), offset);
        } catch (UnsupportedOperationException e) {
            fout.getChannel().position(offset);
        }
    }

    @Override
    public void allocate(@NonNull FileDescriptor fd, long length) throws IOException {
        sysCall.fallocate(fd, length);
    }

    @Override
    public void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null)
                closeable.close();
        } catch (final IOException e) {

        }
    }


    @Override
    public String makeFilename(@NonNull Uri dir, @NonNull String desiredFileName) {

        while (true) {
            /* File doesn't exists, return */
            Uri filePath = getFileUri(dir, desiredFileName);
            if (filePath == null)
                return desiredFileName;
            FsModule fsModule = fsModuleResolver.resolveFsByUri(filePath);
            String fileName = fsModule.getName(filePath);
            if (fileName == null)
                fileName = desiredFileName;
            int openBracketPos = fileName.lastIndexOf("(");
            int closeBracketPos = fileName.lastIndexOf(")");
            /* Try to parse the counter number and increment it for a new filename */
            int countNumber;
            if (openBracketPos > 0 && closeBracketPos > 0) {
                try {
                    countNumber = Integer.parseInt(fileName.substring(openBracketPos + 1, closeBracketPos));
                    desiredFileName = fileName.substring(0, openBracketPos + 1) +
                            ++countNumber + fileName.substring(closeBracketPos);
                    continue;
                } catch (NumberFormatException ignored) {

                    Log.d("Errors", ignored.getMessage());
                }
            }

            /* Otherwise create a name with the initial value of the counter */
            countNumber = 1;
            int extensionPos = fileName.lastIndexOf(EXTENSION_SEPARATOR);
            String baseName = (extensionPos < 0 ? fileName : fileName.substring(0, extensionPos));
            StringBuilder sb = new StringBuilder(baseName + "(" + countNumber + ")");
            if (extensionPos > 0) {
                sb.append(EXTENSION_SEPARATOR)
                        .append(getExtension(fileName));
                desiredFileName = sb.toString();
            }


        }

    }

    @Override
    public void moveFile(@NonNull Uri srcDir, @NonNull String srcFileName, @NonNull Uri destDir, @NonNull String desFileName, boolean replace) throws IOException, FileAlreadyExistsException {

    }

    @Override
    public void copyFile(@NonNull Uri srcDir, @NonNull Uri destDir, boolean truncateDesteFile) throws IOException {

    }

    @Override
    public FileDescriptorWrapper getFD(@NonNull Uri path) {
        return null;
    }

    @Override
    public String getExtensionSeparator() {
        return null;
    }

    @Override
    public String appendExtension(@NonNull String fileName, @NonNull String mimeType) {
        return null;
    }

    @Nullable
    @Override
    public String getDefaultDownloadPath() {
        return null;
    }

    @Nullable
    @Override
    public String getUserDirPath() {
        return null;
    }

    @Override
    public boolean deleteFile(@NonNull Uri path) throws FileNotFoundException {
        return false;
    }

    @Override
    public Uri getFileUri(@NonNull Uri dir, @NonNull String fileName) {
        return null;
    }

    @Override
    public Uri getFileUri(@NonNull String relativePath, @NonNull Uri dir) {
        return null;
    }

    @Override
    public Uri createFile(@NonNull Uri dir, @NonNull String fileName, boolean replace) throws IOException {
        return null;
    }

    @Override
    public long getDirAvailableBytes(@NonNull Uri dir) {
        return 0;
    }

    @Override
    public String getExtension(String fileName) {
        if (fileName == null)
            return null;
        int extensionPos = fileName.lastIndexOf(EXTENSION_SEPARATOR);
        int lastSeparator = fileName.lastIndexOf(File.separator);
        int index = (lastSeparator > extensionPos ? -1 : extensionPos);
        if (index == -1)
            return "";
        else
            return fileName.substring(index + 1);

    }

    @Override
    public boolean isValidFatFileName(String name) {
        return false;
    }

    @Override
    public String buildValidFatFileName(String name) {
        return null;
    }

    @Override
    public String getDirName(@NonNull Uri dir) {
        return null;
    }

    @Override
    public long getFileSize(@NonNull Uri filePath) {
        return 0;
    }

    @Override
    public void truncate(@NonNull Uri filePath, long newSize) throws IOException {

    }

    @Override
    public void takePermissions(@NonNull Uri path) {

    }

    @Override
    public String getDirPath(@NonNull Uri dir) {
        return null;
    }

    @Override
    public boolean exists(@NonNull Uri filePath) {
        return false;
    }
}
