package com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.R;
import com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.api.Post;
import com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {
    private PostAdapterNews postAdapter;
    private RecyclerView rvPost;

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // initialize view
        rvPost = view.findViewById(R.id.rvNews);
        // Initialize recyclerview and adapter
        postAdapter = new PostAdapterNews();
        rvPost.setAdapter(postAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,
                false);
        rvPost.setLayoutManager(layoutManager);
        getDummyPost();
    }

    private void getDummyPost() {
        List<Post> postList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Post post = new Post();
            post.setId(i);
            post.setTitle("Judul Post ke " + i);
            post.setDate("19 September 2021");
            post.setThumbnailUrl("https://blog.hacktiv8.com/content/images/size/w2000/2017/02/coding-screen.jpeg");
            postList.add(post);
        }
        postAdapter.setListPost(postList);
    }
}