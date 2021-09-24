package com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.api;

import com.google.gson.annotations.SerializedName;

public class PostRequest {
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;
    @SerializedName("image_path")
    private String imageBase64;

    public PostRequest() {
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getImageBase64() {
        return imageBase64;
    }
    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
}
