package com.example.mytask51NewsApp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

//import com.example.mytask51NewsApp.R.id;
import com.example.mytask51_news_app.R;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    newsRecyclerViewAdapter newsRecyclerViewAdapter;
    List<News> newsList = new ArrayList<>();

    String[] headlineList = {"Crocs Go WILD", "Footy's Back!", "Temperature Plummets", "Rush on Light 'n Tangy", "NT voted tourist mecca", "Croc nets banned to save community"};
    String[] contentList = {"Salty numbers out of control, as CLP leader Lia Finocchiaro calls for a cull.", "Footy is back in the NT with 4 games at TIO and Alice stadiums this season.", "Get out your socks and jumpers as temperature is forecast to dip below 23 degrees C.", "Lays announces discontinuation of public favourite Light 'n Tangy, causing a rush to stores from punters hoping to secure some supplies.", "Global surveys reveal Australia's Northern Territory at the top of the bucket list for international travellers over 55", "Controversial decision to ban installation of croc nets at NT beaches, in order to prevent tourist flood and overdevelopment of protected waterfront reserves in Darwin"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerViewNews);
        newsRecyclerViewAdapter = new newsRecyclerViewAdapter(newsList, this);
        recyclerView.setAdapter(newsRecyclerViewAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        for (int i = 0; i < headlineList.length; i++) {
            News news = new News(i, headlineList[i], contentList[i]);
            newsList.add(news);
        }
    }

    public void selectFragment(View view) {
        Fragment fragment;


        switch (view.getId())
        {
            case R.id.buttonStoryOne:
                fragment = new story1Fragment();
                break;
            case R.id.buttonStoryTwo:
                fragment = new story2Fragment();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment).commit();


    }
}