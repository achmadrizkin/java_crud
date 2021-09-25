package com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.ui.favorite;

import android.content.Intent;
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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.R;
import com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.api.BlogClient;
import com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.api.BlogServiceGenerator;
import com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.api.Post;
import com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.api.PostList;
import com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.ui.createEdit.CreateEditActivity;
import com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.ui.news.NewsFragment;
import com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.ui.news.PostAdapterNews;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoriteFragment extends Fragment {
    private PostAdapterFavorite postAdapter;
    private RecyclerView rvNews;
    private ProgressBar pbLoading;
    private SwipeRefreshLayout swipeRefreshLayout;

    public static FavoriteFragment newInstance() {
        return new FavoriteFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        rvNews = view.findViewById(R.id.rvNews);
        pbLoading = view.findViewById(R.id.pbLoading);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerview();
        fetchData();
        initSwipeRefresh();
    }

    private void initSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchData();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void fetchData() {
        pbLoading.setVisibility(View.VISIBLE);
        BlogClient client = BlogServiceGenerator.createService(BlogClient.class);
        client.getListPost().enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {
                pbLoading.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    postAdapter.setPostList(response.body().getData());
                } else {
                    Toast.makeText(getContext(), "Gagal fetch data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PostList> call, Throwable t) {
                pbLoading.setVisibility(View.GONE);
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initRecyclerview() {
        postAdapter = new PostAdapterFavorite();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,
                false);
        rvNews.setLayoutManager(linearLayoutManager);
        rvNews.setAdapter(postAdapter);
    }


}