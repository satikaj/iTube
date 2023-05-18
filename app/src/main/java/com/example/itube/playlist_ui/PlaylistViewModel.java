package com.example.itube.playlist_ui;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.itube.data.Playlist;
import com.example.itube.data.iTubeRepository;

import java.util.List;

public class PlaylistViewModel extends AndroidViewModel {

    private final iTubeRepository repository;

    public PlaylistViewModel(Application application) {
        super(application);
        repository = new iTubeRepository(application);
    }

    public void insertUrl(Playlist playlistUrl) {
        repository.insertUrl(playlistUrl);
    }

    public void deleteUrl(Playlist playlistUrl) {
        repository.deleteUrl(playlistUrl);
    }

    public LiveData<List<Playlist>> getPlaylist(String username) {
        return repository.getPlaylist(username);
    }
}
