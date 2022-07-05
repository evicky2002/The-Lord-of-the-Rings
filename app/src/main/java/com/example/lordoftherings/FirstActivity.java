package com.example.lordoftherings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.lordoftherings.DataModels.BookModel;
import com.example.lordoftherings.NetworkActivity.DataService;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class FirstActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MaterialCardView materialCardView;
    DataService dataService = new DataService(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        materialCardView = (MaterialCardView) findViewById(R.id.btnBooks);
        recyclerView = (RecyclerView) findViewById(R.id.recylerView);
        materialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("HELLO","HERE");

                dataService.getBooks(new DataService.BookListener() {
                    @Override
                    public void onResponse(List<BookModel> response) {
                        BookAdapter adapter = new BookAdapter(response);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(FirstActivity.this));
                        recyclerView.setAdapter(adapter);

                    }

                    @Override
                    public void onError(String placeholder) {
                        Log.i("HELLO","error in response");
                    }
                });
            }
        });
    }
}