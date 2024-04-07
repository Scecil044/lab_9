package com.example.lab_9;

public class Article {
    private String title;
    private String url;
    private String sectionName;

    public Article(String title, String url, String sectionName) {
        this.title = title;
        this.url = url;
        this.sectionName = sectionName;
    }

    // Setter methods
    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    // Getter methods
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

