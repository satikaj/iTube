package com.example.itube.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PlaylistDao {
    @Insert
    public void insertUrl(Playlist playlistUrl);

    @Delete
    public void deleteUrl(Playlist playlistUrl);

    @Query("SELECT * FROM playlist_table WHERE username = :username")
    public LiveData<List<Playlist>> getPlaylist(String username);

    @Query("SELECT url FROM playlist_table WHERE username = :username")
    public List<String> getUrls(String username);
}
