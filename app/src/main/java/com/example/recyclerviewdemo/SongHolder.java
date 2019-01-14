package com.example.recyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mkonst on 1/13/19.
 */

public class SongHolder extends RecyclerView.ViewHolder {
    private TextView titleView;
    private TextView artistView;
    private TextView albumView;

    private Song song;

    public SongHolder(@NonNull View itemView) {
        super(itemView);
        // Find the views
        titleView = (TextView) itemView.findViewById(R.id.title);
        artistView = (TextView) itemView.findViewById(R.id.artist);
        albumView = (TextView) itemView.findViewById(R.id.album);
        // Set an onclick listener on the itemView if you want
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), song.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void bindSong(Song song) {
        this.song = song;
        // Populate the views
        titleView.setText(song.getTitle());
        artistView.setText(song.getArtist());
        albumView.setText(song.getAlbum());
    }
}
