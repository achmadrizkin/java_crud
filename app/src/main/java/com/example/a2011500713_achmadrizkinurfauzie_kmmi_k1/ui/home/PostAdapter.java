package com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.ui.home;

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

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    public final List<Post> listPost = new ArrayList<>();

    void setListPost(List<Post> listPost) {
        this.listPost.addAll(listPost);
        this.notifyDataSetChanged();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivThumbnail;
        private final TextView tvTitle;
        private final TextView tvDate;
        private final ImageView ivFavorite;

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
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder holder, int position) {
        holder.bindItem(listPost.get(position));
    }

    @Override
    public int getItemCount() {
        return listPost.size();
    }
}
