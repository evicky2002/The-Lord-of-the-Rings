package com.example.lordoftherings.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lordoftherings.ChaptersActivity;
import com.example.lordoftherings.DataModels.BookModel;
import com.example.lordoftherings.R;

import java.util.ArrayList;
import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ViewHolder> {
    int chapterNumber = 1;
    private ArrayList<String> chapters;
    Context context;
    public ChapterAdapter(ArrayList<String> list, Context context) {
        chapters = list;
        this.context = context;
    }
    @NonNull
    @Override
    public ChapterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chapter_item, parent, false);

        return new ChapterAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ChapterAdapter.ViewHolder holder, int position) {
        holder.tvChapterName.setText(chapters.get(position));
        chapterNumber++;
    }

    @Override
    public int getItemCount() {
        return chapters.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvChapterName;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            tvChapterName = (TextView) view.findViewById(R.id.tvChapterName);
        }


    }

}
