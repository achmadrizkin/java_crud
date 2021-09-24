package com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.ui.home;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.R;
import com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.api.Post;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    public final List<Post> listPost = new ArrayList<>();
    private final HomeAdapterActionListener actionListener;

    public PostAdapter(HomeAdapterActionListener actionListener) {
        this.actionListener = actionListener;
    }

    void setPostList(List<Post> postList) {
        this.listPost.clear();
        this.listPost.addAll(postList);
        this.notifyDataSetChanged();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder {
        private final HomeAdapterActionListener actionListener;
        private final ImageView ivThumbnail;
        private final TextView tvTitle;
        private final TextView tvDate;
        private final ImageView ivFavorite;
        // private final ImageView ivManage = itemView.findViewById(R.id.ivManage);
        private final CardView cvItem = itemView.findViewById(R.id.cvItem);

        public PostViewHolder(@NonNull View itemView, HomeAdapterActionListener actionListener) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.ivThumbnail);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDate = itemView.findViewById(R.id.tvDateNews);
            ivFavorite = itemView.findViewById(R.id.ivFavorite);
            this.actionListener = actionListener;
        }

        public void bindItem(Post post) {
            tvTitle.setText(post.getTitle());
            tvDate.setText(post.getCreatedAt());
            Glide.with(itemView.getContext()).load(post.getThumbnailUrl()).into(ivThumbnail);

            cvItem.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    PopupMenu popupMenu = new PopupMenu(cvItem.getContext(), cvItem);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.action_edit:
                                    // TODO::Navigate to Create Delete Activity
                                    actionListener.onClickEdit(post);
                                    return true;
                                case R.id.action_delete:
                                    // TODO::SHOW POPUP TO DELETE
                                    actionListener.onClickDelete(post, getAbsoluteAdapterPosition());
                                    return true;
                                default:
                                    return false;
                            }
                        }
                    });
                    // inflate your menu
                    popupMenu.inflate(R.menu.my_news_list_menu);
                    popupMenu.setGravity(Gravity.RIGHT);
                    popupMenu.show();
                }
            });

        }
    }

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new PostViewHolder(view, actionListener);
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
