package com.example.itube.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "playlist_table")
public class Playlist {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "url_id")
    public int uid;

    @NonNull
    @ColumnInfo(name = "username")
    public String username;

    @NonNull
    @ColumnInfo(name = "url")
    public String url;

    public Playlist(@NonNull String username, @NonNull String url) {
        this.username = username;
        this.url = url;
    }

    public int getUid() {
        return uid;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    @NonNull
    public String getUrl() {
        return url;
    }
}
