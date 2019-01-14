package com.example.recyclerviewdemo;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by mkonst on 1/13/19.
 */

@Dao
public interface SongDao {

    @Insert
    void insert(Song song);

    @Query("SELECT * FROM song_table ORDER BY title ASC")
    LiveData<List<Song>> getAllSongs();
}
