package com.example.recyclerviewdemo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by mkonst on 1/13/19.
 */

@Entity(tableName = "song_table")
public class Song {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "title")
    private final String title;
    @ColumnInfo(name = "artist")
    private final String artist;
    @ColumnInfo(name = "album")
    private final String album;

    public Song(String title, String artist, String album) {
        this.title = title;
        this.artist = artist;
        this.album = album;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }
}
