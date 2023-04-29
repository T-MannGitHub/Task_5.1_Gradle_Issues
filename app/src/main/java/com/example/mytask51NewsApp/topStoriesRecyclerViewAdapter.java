package com.example.mytask51NewsApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytask51_news_app.R;

import java.util.List;

public class topStoriesRecyclerViewAdapter extends RecyclerView.Adapter<topStoriesRecyclerViewAdapter.ViewHolder> {
    //view holder acts as a reference to the memory. Using this to allow access and binds data to the view
    //recycler view adapter binds data between the recycler view and the news class text view(xml), and then binding the data
    //to the data model in the news.java class and the dataset
    private List<TopStories> topStoriesList;
    private Context context;

    public topStoriesRecyclerViewAdapter(List<TopStories> topStoriesList, Context context) {
        this.topStoriesList = topStoriesList;
        this.context = context;
    }

    @NonNull
    @Override
    public topStoriesRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.top_stories, parent, false);
        return new ViewHolder(itemView);
    }
    //onCreate inflates the news text view with the data

    @Override
    public void onBindViewHolder(@NonNull topStoriesRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.topStoriesHeadlineTextView.setText(topStoriesList.get(position).getHeadline());
        holder.topStoriesImageView.setImageResource(topStoriesList.get(position).getNewsImage());
    }
    //populate data into the item

    @Override
    public int getItemCount() {
        return topStoriesList.size();
    }
    //helper - return the size of dataset

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView topStoriesHeadlineTextView;
        ImageView topStoriesImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topStoriesHeadlineTextView = itemView.findViewById(R.id.newsHeadlineTextView);
            topStoriesImageView = itemView.findViewById(R.id.newsContentImageView);
        }
    }
    //extends superclass so needs a constructor
}
