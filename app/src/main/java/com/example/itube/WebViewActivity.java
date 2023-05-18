package com.example.itube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.itube.databinding.ActivityWebViewBinding;

import java.util.List;

public class WebViewActivity extends AppCompatActivity {

    ActivityWebViewBinding binding;
    WebView webView;
    List<String> playlist;
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebViewBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Setup webview
        webView = binding.webView;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                view.loadUrl("javascript:player.playerVideo();");
            }
        });

        // Get urls in playlist
        Intent playIntent = getIntent();
        playlist = (List<String>) playIntent.getSerializableExtra("playlist");

        // If playlist is empty, go back to home activity
        if (playlist == null) finish();

        // Play the first video in playlist
        playVideo(playlist.get(currentIndex));

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Play the next video in playlist. If no more videos in playlist, start from the beginning
                currentIndex++;
                if (currentIndex >= playlist.size()) currentIndex = 0;
                playVideo(playlist.get(currentIndex));
            }
        });
    }

    private void playVideo(String url) {
        webView.loadData(
                "<html>" +
                        "<body>" +
                        "<iframe width=\"100%\" height=\"100%\" src=\"" +
                        url +
                        "?enablejsapi=1\" frameborder=\"0\" allowfullscreen>" +
                        "</iframe>" +
                        "</body>" +
                        "</html>",
                "text/html",
                "utf-8");
    }
}