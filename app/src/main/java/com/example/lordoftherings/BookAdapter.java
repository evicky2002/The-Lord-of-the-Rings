package com.example.lordoftherings;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lordoftherings.DataModels.BookModel;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<BookModel> bookModels;
    Context context;
    public BookAdapter(List<BookModel> list, Context context) {
        bookModels = list;
        this.context = context;
    }
    @NonNull
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull BookAdapter.ViewHolder holder, int position) {
        holder.tvName.setText(bookModels.get(position).getName());
        holder.tvTotalChapters.setText("No. of Chapters : "+bookModels.get(position).getTotalChapters());

        switch (position){
            case 0: holder.ivBook.setImageResource(R.drawable.book_one);
                    break;
            case 1: holder.ivBook.setImageResource(R.drawable.book_two);
                    break;
            case 2: holder.ivBook.setImageResource(R.drawable.book_three);
                    break;
        }

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ChaptersActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvName, tvTotalChapters;
        ImageView ivBook;
        ConstraintLayout parentLayout;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            tvName = (TextView) view.findViewById(R.id.tvName);
            ivBook = (ImageView) view.findViewById(R.id.ivBook);
            tvTotalChapters = (TextView) view.findViewById(R.id.tvTotalChapters);

            parentLayout = (ConstraintLayout) view.findViewById(R.id.book_item_layout);
        }
        public TextView getNameTextView() {
            return tvName;
        }

    }
}
