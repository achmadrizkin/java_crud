package com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.ui.home;

import com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.api.Post;

public interface HomeAdapterActionListener {
    void onClickDelete(Post post, int absoluteAdapterPosition);
    void onClickEdit(Post post);
}
