package com.example.recyclerviewdemo;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by mkonst on 1/13/19.
 */

public class SongRepository {
    private SongDao songDao;
    private LiveData<List<Song>> songs;

    public SongRepository(Application application) {
        SongDatabase db = SongDatabase.getDatabase(application);
        songDao = db.songDao();
        songs = songDao.getAllSongs();
    }

    LiveData<List<Song>> getSongs() {
        return songs;
    }

    public void insert(Song song) {
        new insertAsyncTask(songDao).execute(song);
    }

    private static class insertAsyncTask extends AsyncTask<Song, Void, Void> {

        private SongDao mAsyncTaskDao;

        insertAsyncTask(SongDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Song... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
