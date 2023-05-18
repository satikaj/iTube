package com.example.itube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.itube.databinding.ActivityMyPlaylistBinding;
import com.example.itube.playlist_ui.PlaylistListAdapter;
import com.example.itube.playlist_ui.PlaylistViewModel;

public class MyPlaylistActivity extends AppCompatActivity {

    ActivityMyPlaylistBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyPlaylistBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent usernameIntent = getIntent();
        String username = usernameIntent.getStringExtra("username");

        RecyclerView recyclerView = findViewById(R.id.urlRV);
        final PlaylistListAdapter adapter = new PlaylistListAdapter(new PlaylistListAdapter.PlaylistDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Ensure playlist data is up to date
        PlaylistViewModel playlistViewModel = new ViewModelProvider(this).get(PlaylistViewModel.class);
        playlistViewModel.getPlaylist(username).observe(this, playlist -> {
            adapter.submitList(playlist);
        });
    }
}