package com.example.lordoftherings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lordoftherings.DataModels.BookModel;
import com.example.lordoftherings.NetworkActivity.DataService;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class FirstActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView ivBooks, ivMovies;
    Intent bookIntent, movieIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        bookIntent = new Intent(FirstActivity.this,BookActivity.class);
        movieIntent = new Intent(FirstActivity.this,MovieActivity.class);
        ivBooks = (ImageView) findViewById(R.id.ivBooks);
        ivMovies= (ImageView) findViewById(R.id.ivMovies);

        ivBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(bookIntent);
            }
        });
        ivMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(movieIntent);
            }
        });
    }
}