package com.example.itube.playlist_ui;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.itube.data.Playlist;

public class PlaylistListAdapter extends ListAdapter<Playlist, PlaylistViewHolder> {

    public PlaylistListAdapter(@NonNull DiffUtil.ItemCallback<Playlist> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public PlaylistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return PlaylistViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(PlaylistViewHolder holder, int position) {
        Playlist current = getItem(position);
        holder.bind(current.getUrl());
    }

    public static class PlaylistDiff extends DiffUtil.ItemCallback<Playlist> {

        @Override
        public boolean areItemsTheSame(@NonNull Playlist oldItem, @NonNull Playlist newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Playlist oldItem, @NonNull Playlist newItem) {
            return oldItem.getUrl().equals(newItem.getUrl());
        }
    }
}
