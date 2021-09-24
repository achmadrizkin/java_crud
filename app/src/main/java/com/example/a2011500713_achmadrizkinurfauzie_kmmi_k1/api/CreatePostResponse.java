package com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.api;

import com.google.gson.annotations.SerializedName;

public class CreatePostResponse {
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;
    public CreatePostResponse() {
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
