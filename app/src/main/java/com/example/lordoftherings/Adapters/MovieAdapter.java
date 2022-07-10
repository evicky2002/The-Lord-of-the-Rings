package com.example.lordoftherings.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lordoftherings.DataModels.MovieModel;
import com.example.lordoftherings.R;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        holder.tvNovieName.setText(movieModels.get(position).getName());
        holder.tvRuntime.setText("Runtime : "+movieModels.get(position).getRuntimeInMinutes()+" minutes");
        switch (position){
            case 0: holder.ivMovie.setImageResource(R.drawable.movie_one);
                break;
            case 1: holder.ivMovie.setImageResource(R.drawable.movie_two);
                break;
            case 2: holder.ivMovie.setImageResource(R.drawable.movie_three);
                break;
            case 3: holder.ivMovie.setImageResource(R.drawable.movie_four);
                break;
            case 4: holder.ivMovie.setImageResource(R.drawable.movie_five);
                break;
            case 5: holder.ivMovie.setImageResource(R.drawable.movie_six);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return movieModels.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvNovieName, tvRuntime;
        ImageView ivMovie;
        ConstraintLayout parentLayout;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            tvRuntime = (TextView) view.findViewById(R.id.tvRuntime);
            tvNovieName = (TextView) view.findViewById(R.id.tvMovieName);
            ivMovie = (ImageView) view.findViewById(R.id.ivMovie) ;
            parentLayout = (ConstraintLayout) view.findViewById(R.id.movie_item_layout);
        }

    }
}
