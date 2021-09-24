package com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BlogClient {
    @GET("posts.php?function=get_posts")
    Call<PostList> getListPost();

    @POST("posts.php?function=insert_posts")
    Call<CreatePostResponse> createPostRequest(@Body PostRequest request);
}
