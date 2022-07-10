package com.example.lordoftherings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.lordoftherings.Adapters.ChapterAdapter;
import com.example.lordoftherings.DataModels.BookModel;

import java.util.ArrayList;
import java.util.List;

public class ChaptersActivity extends AppCompatActivity {
    RecyclerView recyclerView_chapters;
    ArrayList<String> bookModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);
        Log.i("CHAPTERSACTIVITY","here");
        Intent intent = getIntent();
//        int position = intent.getIntExtra("POSITION",0);
        bookModels = intent.getStringArrayListExtra("CHAPTERS");
        ChapterAdapter adapter = new ChapterAdapter(bookModels,ChaptersActivity.this);
        recyclerView_chapters = (RecyclerView) findViewById(R.id.recylerView_chapters);
        recyclerView_chapters.setHasFixedSize(true);
        recyclerView_chapters.setLayoutManager(new LinearLayoutManager(ChaptersActivity.this));
        recyclerView_chapters.setAdapter(adapter);
    }
}