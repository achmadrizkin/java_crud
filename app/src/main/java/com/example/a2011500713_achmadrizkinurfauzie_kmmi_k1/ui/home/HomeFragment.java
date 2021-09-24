package com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.ui.home;

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
import com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.api.PostList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private PostAdapter postAdapter;
    private RecyclerView rvPost;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar pbLoading;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // initialize view
        rvPost = view.findViewById(R.id.rvNews);

        // initialize recylerView and adapter
        postAdapter = new PostAdapter();
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

        fetchData();
    }

    private void fetchData() {
//        pbLoading.setVisibility(View.VISIBLE);
        BlogClient client = BlogServiceGenerator.createService(BlogClient.class);
        client.getListPost().enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {
//                pbLoading.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    postAdapter.setListPost(response.body().getData());
                } else {
                    Toast.makeText(getContext(), "Gagal fetch data",
                            Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<PostList> call, Throwable t) {
//                pbLoading.setVisibility(View.GONE);
                Toast.makeText(getContext(), t.getLocalizedMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}