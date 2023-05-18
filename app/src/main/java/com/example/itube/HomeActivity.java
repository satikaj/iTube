package com.example.itube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.itube.data.Playlist;
import com.example.itube.data.PlaylistDao;
import com.example.itube.data.iTubeDatabase;
import com.example.itube.databinding.ActivityHomeBinding;
import com.example.itube.playlist_ui.PlaylistViewModel;

import java.io.Serializable;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent usernameIntent = getIntent();
        String username = usernameIntent.getStringExtra("username");

        PlaylistViewModel playlistViewModel = new ViewModelProvider(this).get(PlaylistViewModel.class);

        binding.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pass playlist to the play activity
                iTubeDatabase db = iTubeDatabase.getDatabase(getApplication());
                PlaylistDao playlistDao = db.playlistDao();
                iTubeDatabase.databaseWriteExecutor.execute(() -> {
                    List<String> playlist = playlistDao.getUrls(username);

                    Intent playIntent = new Intent(HomeActivity.this, WebViewActivity.class);
                    playIntent.putExtra("playlist", (Serializable) playlist);
                    startActivity(playIntent);
                });
            }
        });

        binding.addToPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Insert url to the user's playlist
                String url = binding.url.getText().toString();
                playlistViewModel.insertUrl(new Playlist(username, url));
                Toast.makeText(HomeActivity.this, "URL added to your playlist!", Toast.LENGTH_SHORT).show();
            }
        });

        binding.myPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myPlaylistIntent = new Intent(HomeActivity.this, MyPlaylistActivity.class);
                myPlaylistIntent.putExtra("username", username);
                startActivity(myPlaylistIntent);
            }
        });
    }
}