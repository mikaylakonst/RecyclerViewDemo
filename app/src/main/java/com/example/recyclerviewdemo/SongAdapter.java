package com.example.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkonst on 1/13/19.
 */

public class SongAdapter extends RecyclerView.Adapter<SongHolder> {

    private List<Song> songs;

    public SongAdapter() {
        this.songs = new ArrayList<>();
    }

    @Override
    public SongHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.song_holder, parent, false);
        return new SongHolder(view);
    }

    @Override
    public void onBindViewHolder(SongHolder holder, int position) {
        holder.bindSong(songs.get(position));
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
        notifyDataSetChanged();
    }
}
