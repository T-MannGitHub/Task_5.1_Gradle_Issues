package com.example.mytask51_news_app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mytask51NewsApp.RelatedNews;
import com.example.mytask51NewsApp.RelatedNewsRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link story6Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class story6Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<RelatedNews> relatedNewsList;
    private String[] relatedNewsheadlineList;
    private int[] relatedNewsImage;
    private RecyclerView recyclerViewRelatedNews;


    public story6Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment story6Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static story6Fragment newInstance(String param1, String param2) {
        story6Fragment fragment = new story6Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_story6, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialise();

        recyclerViewRelatedNews = view.findViewById(R.id.recyclerView);
        recyclerViewRelatedNews.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerViewRelatedNews.setHasFixedSize(true);

        RelatedNewsRecyclerViewAdapter relatedNewsRecyclerViewAdapter = new RelatedNewsRecyclerViewAdapter(relatedNewsList, getContext());
        recyclerViewRelatedNews.setAdapter(relatedNewsRecyclerViewAdapter);
        relatedNewsRecyclerViewAdapter.notifyDataSetChanged();



    }

    private void dataInitialise() {
        relatedNewsList = new ArrayList<>();

        relatedNewsheadlineList = new String[] {"DarwinCup", "Territory Day", "Humpty Doo"};
        relatedNewsImage = new int[] {R.drawable.darwin_cup1, R.drawable.territory_day2, R.drawable.humpty_doo_hotel3};

        for (int k = 0; k < relatedNewsheadlineList.length; k++) {
            RelatedNews relatedNews = new RelatedNews(k, relatedNewsImage[k], relatedNewsheadlineList[k]);
            relatedNewsList.add(relatedNews);
        }

    }
}