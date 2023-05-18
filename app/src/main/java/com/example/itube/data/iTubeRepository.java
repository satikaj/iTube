package com.example.itube.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class iTubeRepository {
    private final UserDao userDao;

    private final PlaylistDao playlistDao;

    public iTubeRepository(Application application) {
        iTubeDatabase db = iTubeDatabase.getDatabase(application);
        userDao = db.userDao();
        playlistDao = db.playlistDao();
    }

    public void insertUser(User user) {
        iTubeDatabase.databaseWriteExecutor.execute(() -> {
            userDao.insertUser(user);
        });
    }

    public void insertUrl(Playlist playlistUrl) {
        iTubeDatabase.databaseWriteExecutor.execute(() -> {
            playlistDao.insertUrl(playlistUrl);
        });
    }

    public void deleteUrl(Playlist playlistUrl) {
        iTubeDatabase.databaseWriteExecutor.execute(() -> {
            playlistDao.deleteUrl(playlistUrl);
        });
    }

    public LiveData<List<Playlist>> getPlaylist(String username) {
        return playlistDao.getPlaylist(username);
    }
}
