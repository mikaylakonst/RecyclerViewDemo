package com.example.recyclerviewdemo;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private SongAdapter adapter = new SongAdapter();



    private static final String TAG = "ListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.i(TAG, "onCreate");
        RecyclerView list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        //list.setLayoutManager(new GridLayoutManager(this, 2));
        list.setAdapter(adapter);
        SongRepository songRepository = new SongRepository(getApplication());
        songRepository.getSongs().observe(this, new Observer<List<Song>>() {
            @Override
            public void onChanged(@Nullable List<Song> songs) {
                adapter.setSongs(songs);
            }
        });
    }


    public void startAddSongActivity(View view) {
        Intent intent = new Intent(this, AddSongActivity.class);
        startActivity(intent);
    }
}
