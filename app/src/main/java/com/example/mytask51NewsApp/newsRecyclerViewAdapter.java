package com.example.mytask51NewsApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytask51_news_app.R;

import java.util.List;

public class newsRecyclerViewAdapter extends RecyclerView.Adapter<newsRecyclerViewAdapter.ViewHolder> {
    //view holder acts as a reference to the memory. Using this to allow access and binds data to the view
    //recycler view adapter binds data between the recycler view and the news class text view(xml), and then binding the data
    //to the data model in the news.java class and the dataset
    private List<News> newsList;
    private Context context;

    public newsRecyclerViewAdapter(List<News> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    @NonNull
    @Override
    public newsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.news, parent, false);

        return new ViewHolder(itemView);
    }
    //onCreate inflates the news text view with the data

    @Override
    public void onBindViewHolder(@NonNull newsRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.newsHeadlineTextView.setText(newsList.get(position).getHeadline());
        holder.newsContentTextView.setText(newsList.get(position).getContent());
    }
    //populate data into the item

    @Override
    public int getItemCount() {
        return newsList.size();
    }
    //helper - return the size of dataset

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView newsHeadlineTextView;
        TextView newsContentTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsHeadlineTextView = itemView.findViewById(R.id.newsHeadlineTextView);
            newsContentTextView = itemView.findViewById(R.id.newsContentTextView);
        }
    }
    //extends superclass so needs a constructor
}
