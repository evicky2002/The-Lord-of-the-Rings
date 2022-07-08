package com.example.lordoftherings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.lordoftherings.DataModels.BookModel;
import com.example.lordoftherings.DataModels.MovieModel;
import com.example.lordoftherings.NetworkActivity.DataService;

import java.util.List;

public class MovieActivity extends AppCompatActivity {
    RecyclerView recyclerView2;
    DataService dataService = new DataService(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        Log.i("HELLO","HERE BRO");
        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        dataService.getMovies(new DataService.MovieListener() {
            @Override
            public void onResponse(List<MovieModel> response) {
                MovieAdapter adapter = new MovieAdapter(response, MovieActivity.this);
                recyclerView2.setHasFixedSize(true);
                recyclerView2.setLayoutManager(new LinearLayoutManager(MovieActivity.this));
                recyclerView2.setAdapter(adapter);

            }

            @Override
            public void onError(String placeholder) {
                Log.i("HELLO","error in response");
            }
        });
    }
}