package com.example.lordoftherings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.lordoftherings.DataModels.BookModel;
import com.example.lordoftherings.NetworkActivity.DataService;

import java.util.List;

public class BookActivity extends AppCompatActivity {
    DataService dataService = new DataService(this);
    List<BookModel> bookModels;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        recyclerView = (RecyclerView) findViewById(R.id.recylerView);

        dataService.getBooks(new DataService.BookListener() {
            @Override
            public void onResponse(List<BookModel> response) {
                bookModels = response;
                BookAdapter adapter = new BookAdapter(response, BookActivity.this);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(BookActivity.this));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onError(String placeholder) {
                Log.i("HELLO","error in response");
            }
        });
    }
}