package com.example.mytask51NewsApp;


import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytask51_news_app.R;
import com.example.mytask51_news_app.story4Fragment;
import com.example.mytask51_news_app.story5Fragment;
import com.example.mytask51_news_app.story6Fragment;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity implements newsRecyclerViewAdapter.OnRowClickListener{
    RecyclerView recyclerViewTopStories, recyclerViewNews;
    com.example.mytask51NewsApp.topStoriesRecyclerViewAdapter topStoriesRecyclerViewAdapter;
    com.example.mytask51NewsApp.newsRecyclerViewAdapter newsRecyclerViewAdapter;

    List<TopStories> topStoriesList = new ArrayList<>();
    List<News> newsList = new ArrayList<>();

    FragmentContainerView fragmentContainer;


    String[] headlineList = {"Crocs Go WILD", "Footy's Back!", "Temperature Plummets", "Rush on Light 'n Tangy", "NT voted tourist mecca", "Croc nets banned to save community"};
    String[] contentList = {"Salty numbers out of control, as CLP leader Lia Finocchiaro calls for a cull.", "Footy is back in the NT with 4 games at TIO and Alice stadiums this season.", "Get out your socks and crocs as temperature is forecast to dip below 23 degrees C.", "Thins announces discontinuation of cult favourite Light 'n Tangy, causing a rush to stores from punters hoping to secure supplies.", "Global surveys reveal Australia's Northern Territory at the top of the bucket list for international travellers over 55", "Controversial decision to ban installation of croc nets at NT beaches, in order to prevent tourist flood and overdevelopment of protected waterfront reserves in Darwin"};

    String[] subHeadingList = {"Croc Country", "Footy NT", "Cold Snap", "Light n' Tangy", "Tourism HotSpot", "No Nets!"};

    int[] newsImage = {R.drawable.story_1_croc, R.drawable.story_2_footy, R.drawable.story_3_socks, R.drawable.story_4_chips_,
    R.drawable.story_5_tourists, R.drawable.story_6_nets};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //replaceFragment (new story1Fragment());

        recyclerViewTopStories = findViewById(R.id.recyclerViewTopStories);
        recyclerViewNews = findViewById(R.id.recyclerViewNews);

        fragmentContainer = findViewById(R.id.fragmentContainerView);

        topStoriesRecyclerViewAdapter = new topStoriesRecyclerViewAdapter(topStoriesList, this);
        newsRecyclerViewAdapter = new newsRecyclerViewAdapter(newsList, this, this);

        recyclerViewTopStories.setAdapter(topStoriesRecyclerViewAdapter);
        recyclerViewNews.setAdapter(newsRecyclerViewAdapter);

        recyclerViewTopStories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewNews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));



        for (int i = 0; i < headlineList.length; i++) {
            TopStories topStories = new TopStories(i, headlineList[i], newsImage[i]);
            topStoriesList.add(topStories);
        }

        for (int j = 0; j < subHeadingList.length; j++) {
            News news = new News(j, subHeadingList[j], contentList[j], newsImage[j]);
            newsList.add(news);
        }
    }



    @Override
    public void onItemCLick(int position) {
        Fragment fragment;
       try {
        switch (position) {
            case 0:
                //Toast.makeText(this, "Croc Country was clicked", Toast.LENGTH_SHORT).show();
                fragment = new story1Fragment();
                break;
            case 1:
                //Toast.makeText(this, "Footy NT was clicked", Toast.LENGTH_SHORT).show();
                fragment = new story2Fragment();
                fragment.isVisible();
                break;
            case 2:
                //Toast.makeText(this, "Cold Snap was clicked", Toast.LENGTH_SHORT).show();
                fragment = new story3Fragment();
                break;
            case 3:
                //Toast.makeText(this, "Light 'n Tangy was clicked", Toast.LENGTH_SHORT).show();
                fragment = new story4Fragment();
                break;
            case 4:
                //Toast.makeText(this, "Tourist Mecca was clicked", Toast.LENGTH_SHORT).show();
                fragment = new story5Fragment();
                break;
            case 5:
                //Toast.makeText(this, "Nr Nets! was clicked", Toast.LENGTH_SHORT).show();
                fragment = new story6Fragment();
                break;

            default:
                throw new IllegalStateException("Unexpected value.");

        }
           FragmentManager fragmentManager = getSupportFragmentManager();
           FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
           fragmentTransaction.replace(R.id.fragmentContainerView, fragment).show(fragment).addToBackStack(null).commit();
       }
        catch (Exception e){
            Toast.makeText(MainActivity.this, "Error in go to fragment section", Toast.LENGTH_SHORT).show();}
    }
}