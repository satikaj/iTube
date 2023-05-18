package com.example.itube.playlist_ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.itube.R;

class PlaylistViewHolder extends RecyclerView.ViewHolder {
    private final TextView item;

    private PlaylistViewHolder(View itemView) {
        super(itemView);
        item = itemView.findViewById(R.id.item);
    }

    public void bind(String text) {
        item.setText(text);
    }

    static PlaylistViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.playlist_list_item, parent, false);
        return new PlaylistViewHolder(view);
    }
}
