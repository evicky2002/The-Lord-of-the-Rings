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
                getChapters(response);
            }

            @Override
            public void onError(String placeholder) {
                Log.i("HELLO","error in response");
            }
        });
    }
    public void getChapters(List<BookModel> bookModels){

        for(int i=0;i<bookModels.size();i++){
            dataService.getChapters(bookModels.get(i).getId(), new DataService.ChapterListener() {
                @Override
                public void onResponse(String response) {
                    Log.i("BOOKACTIVITY",bookModels.get(0).getChapters().toString());

                    BookAdapter adapter = new BookAdapter(bookModels, BookActivity.this);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(BookActivity.this));
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onError(String placeholder) {

                }
            });
        }
    }
}