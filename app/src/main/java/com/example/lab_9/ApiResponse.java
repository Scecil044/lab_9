package com.example.lab_9;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ApiResponse {
    @SerializedName("response")
    private ResponseData responseData;

    public ResponseData getResponseData() {
        return responseData;
    }

    public static class ResponseData {
        @SerializedName("results")
        private List<Article> articles;

        public List<Article> getArticles() {
            return articles;
        }
    }

    public static class Article {
        @SerializedName("webTitle")
        private String title;

        @SerializedName("webUrl")
        private String url;

        @SerializedName("sectionName")
        private String sectionName;

        public String getTitle() {
            return title;
        }

        public String getUrl() {
            return url;
        }

        public String getSectionName() {
            return sectionName;
        }
    }
}

