package com.example.a2011500713_achmadrizkinurfauzie_kmmi_k1.api;

import com.google.gson.annotations.SerializedName;

public class EditPostRequest {
        @SerializedName("title")
        String title;
        @SerializedName("body")
        String body;
        @SerializedName("image_path")
        String imageBase64;
        public EditPostRequest() {
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

