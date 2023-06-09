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

public class newsRecyclerViewAdapter extends RecyclerView.Adapter<newsRecyclerViewAdapter.NewsViewHolder>
{
    private List<News> newsList;
    private Context context;
    private OnRowClickListener listener;

    public newsRecyclerViewAdapter(List<News> newsList, Context context, OnRowClickListener clickListener) {
        this.newsList = newsList;
        this.context = context;
        this.listener = clickListener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.news, parent, false);
        return new NewsViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.newsImageView.setImageResource(newsList.get(position).getNewsImage());
        holder.subHeadingTextView.setText(newsList.get(position).getSubHeading());
        holder.newsContentTextView.setText(newsList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView subHeadingTextView;
        TextView newsContentTextView;
        ImageView newsImageView;
        public OnRowClickListener onRowClickListener;

        public NewsViewHolder(@NonNull View itemView, OnRowClickListener onRowClickListener) {
            super(itemView);
            newsImageView = itemView.findViewById(R.id.imageViewNews);
            subHeadingTextView = itemView.findViewById(R.id.textViewSubHeading);
            newsContentTextView = itemView.findViewById(R.id.textViewNewsContent);
            this.onRowClickListener = onRowClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onRowClickListener.onItemCLick(getAdapterPosition());
        }
    }

    public interface OnRowClickListener {
        void onItemCLick (int position);
    }
}
