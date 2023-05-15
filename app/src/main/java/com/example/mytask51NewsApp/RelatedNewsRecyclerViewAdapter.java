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

public class RelatedNewsRecyclerViewAdapter extends RecyclerView.Adapter<RelatedNewsRecyclerViewAdapter.ViewHolder> {

    private List<RelatedNews> relatedNewsList;
    private Context context;

    public RelatedNewsRecyclerViewAdapter(List<RelatedNews> relatedNewsList, Context context) {
        this.relatedNewsList = relatedNewsList;
        this.context = context;
    }

    @NonNull
    @Override
    public RelatedNewsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.related_news_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RelatedNewsRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.relatedNewsImageView.setImageResource(relatedNewsList.get(position).getImage());
        holder.relatedNewsTextView.setText(relatedNewsList.get(position).getHeadline());
    }

    @Override
    public int getItemCount() {
        return relatedNewsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView relatedNewsImageView;
        TextView relatedNewsTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            relatedNewsImageView = itemView.findViewById(R.id.relatedNewsImageView);
            relatedNewsTextView = itemView.findViewById(R.id.relatedNewsTextView);
        }
    }
}
