package com.example.lordoftherings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lordoftherings.DataModels.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    List<MovieModel> movieModels = new ArrayList<>();
    Context context;

    public MovieAdapter(List<MovieModel> data, Context context) {
        this.movieModels = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        holder.tvName.setText(movieModels.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return movieModels.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvName;
        ConstraintLayout parentLayout;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            tvName = (TextView) view.findViewById(R.id.tvName);
            parentLayout = (ConstraintLayout) view.findViewById(R.id.book_item_layout);
        }
        public TextView getMovieNameTextView() {
            return tvName;
        }

    }
}
