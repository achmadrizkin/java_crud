package com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.ui.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.R;
import com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.api.Post;
import com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.ui.favorite.PostAdapterFavorite;
import com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.ui.home.PostAdapter;

import java.util.ArrayList;
import java.util.List;

public class PostAdapterNews extends RecyclerView.Adapter<PostAdapterNews.PostViewHolder> {
    public final List<Post> listPost = new ArrayList<>();


    void setPostList(List<Post> postList) {
        this.listPost.clear();
        this.listPost.addAll(postList);
        this.notifyDataSetChanged();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivThumbnail;
        private final TextView tvTitle;
        private final TextView tvDate;
        private final ImageView ivFavorite;
        // private final ImageView ivManage = itemView.findViewById(R.id.ivManage);

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.ivThumbnail);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDate = itemView.findViewById(R.id.tvDateNews);
            ivFavorite = itemView.findViewById(R.id.ivFavorite);
        }

        public void bindItem(Post post) {
            tvTitle.setText(post.getTitle());
            tvDate.setText(post.getCreatedAt());
            Glide.with(itemView.getContext()).load(post.getThumbnailUrl()).into(ivThumbnail);
        }
    }

    @NonNull
    @Override
    public PostAdapterNews.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_news, parent, false);
        return new PostAdapterNews.PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapterNews.PostViewHolder holder, int position) {
        holder.bindItem(listPost.get(position));
    }

    @Override
    public int getItemCount() {
        return listPost.size();
    }
}