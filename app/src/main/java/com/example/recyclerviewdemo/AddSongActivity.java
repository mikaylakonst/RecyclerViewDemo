package com.example.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddSongActivity extends AppCompatActivity {

    SongRepository songRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_song);
        songRepository = new SongRepository(getApplication());
    }

    public void onSaveClicked(View view) {
        String title = ((EditText) findViewById(R.id.et_title)).getText().toString();
        String artist = ((EditText) findViewById(R.id.et_artist)).getText().toString();
        String album = ((EditText) findViewById(R.id.et_album)).getText().toString();
        songRepository.insert(new Song(title, artist, album));
        finish();
    }

    public void onCancelClicked(View view) {
        finish();
    }
}