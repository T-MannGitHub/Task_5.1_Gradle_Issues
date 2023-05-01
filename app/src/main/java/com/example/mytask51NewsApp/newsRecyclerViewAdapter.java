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

public class newsRecyclerViewAdapter extends RecyclerView.Adapter<newsRecyclerViewAdapter.ViewHolder>
{
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

    @Override
    public void onBindViewHolder(@NonNull newsRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.newsImageView.setImageResource(newsList.get(position).getNewsImage());
        holder.subHeadingTextView.setText(newsList.get(position).getSubHeading());
        holder.newsContentTextView.setText(newsList.get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView subHeadingTextView;
        TextView newsContentTextView;
        ImageView newsImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImageView = itemView.findViewById(R.id.imageViewNews);
            subHeadingTextView = itemView.findViewById(R.id.textViewSubHeading);
            newsContentTextView = itemView.findViewById(R.id.textViewNewsContent);
        }
    }
}
