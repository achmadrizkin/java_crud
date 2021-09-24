package com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.ui.favorite;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.R;
import com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.api.Post;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends Fragment {
    private PostAdapterFavorite postAdapter;
    private RecyclerView rvPost;
    private SwipeRefreshLayout swipeRefreshLayout;

    public static FavoriteFragment newInstance() {
        return new FavoriteFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // initialize view
        rvPost = view.findViewById(R.id.rvNews);

        // initialize recylerView and adapter
        postAdapter = new PostAdapterFavorite();
        rvPost.setAdapter(postAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,
                false);
        rvPost.setLayoutManager(layoutManager);

        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }


}