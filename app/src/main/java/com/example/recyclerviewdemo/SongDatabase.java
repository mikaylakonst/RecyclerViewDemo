package com.example.recyclerviewdemo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by mkonst on 1/13/19.
 */

@Database(entities = {Song.class}, version = 1, exportSchema = false)
public abstract class SongDatabase extends RoomDatabase {

    public abstract SongDao songDao();

    private static volatile SongDatabase INSTANCE;

    static SongDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SongDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            SongDatabase.class,
                            "song_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
