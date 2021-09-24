package com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BlogClient {
    @GET("posts.php?function=get_posts")
    Call<PostList> getListPost();

    @POST("posts.php?function=insert_posts")
    Call<CreatePostResponse> createPostRequest(@Body PostRequest request);

    @DELETE("posts.php?function=delete_posts")
    Call<DeletePostResponse> deletePost(@Query("id") String id);

    @PATCH("posts.php?function=update_posts")
    Call<EditPostRequest> editPost(@Body EditPostRequest request, @Query("id") String id);
}
