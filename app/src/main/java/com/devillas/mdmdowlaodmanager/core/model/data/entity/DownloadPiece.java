package com.devillas.mdmdowlaodmanager.core.model.data.entity;

import static androidx.room.ForeignKey.CASCADE;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;

import com.devillas.mdmdowlaodmanager.core.model.data.StatusCode;

import java.util.UUID;

@Entity(primaryKeys = {"pieceIndex", "InfoId"},
        indices = {@Index(value = "infoId")},
        foreignKeys = @ForeignKey(
                entity = DownloadInfo.class,
                parentColumns = "id",
                childColumns = "infoId",
                onDelete = CASCADE
        ))
public class DownloadPiece implements Parcelable {

    @ColumnInfo(name = "pieceIndex")
    public int index;
    @NonNull
    public UUID infoId;
    public long size;
    public long curBytes;
    public int statusCode = StatusCode.STATUS_PENDING;
    public String statusMsg;
    public long speed;


    public DownloadPiece(@NonNull UUID infoId, int index, long size, long curBytes) {
        this.index = index;
        this.infoId = infoId;
        this.size = size;
        this.curBytes = curBytes;
    }

    @Ignore
    protected DownloadPiece(@NonNull Parcel source) {
        infoId = (UUID) source.readSerializable();
        size = source.readLong();
        index = source.readInt();
        curBytes = source.readLong();
        statusCode = source.readInt();
        statusMsg = source.readString();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(infoId);
        dest.writeLong(size);
        dest.writeInt(index);
        dest.writeLong(curBytes);
        dest.writeInt(statusCode);
        dest.writeString(statusMsg);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DownloadPiece> CREATOR = new Creator<DownloadPiece>() {
        @Override
        public DownloadPiece createFromParcel(Parcel in) {
            return new DownloadPiece(in);
        }

        @Override
        public DownloadPiece[] newArray(int size) {
            return new DownloadPiece[size];
        }
    };


    @Override
    public int hashCode() {
        int prime = 31, result = 1;
        result = prime * result + index;
        result = prime * result + infoId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof DownloadPiece))
            return false;
        if (o == this)
            return true;
        DownloadPiece piece = (DownloadPiece) o;
        return infoId.equals(piece.infoId) &&
                index == piece.index &&
                size == piece.size &&
                curBytes == piece.curBytes &&
                speed == piece.speed &&
                statusCode == piece.statusCode &&
                (statusMsg == null || statusMsg.equals(piece.statusMsg));
    }

    @Override
    public String toString() {
        return "DownloadPiece{" +
                "index=" + index +
                ", infoId=" + infoId +
                ", size=" + size +
                ", curBytes=" + curBytes +
                ", statusCode=" + statusCode +
                ", statusMsg='" + statusMsg + '\'' +
                ", speed=" + speed +
                '}';
    }
}
