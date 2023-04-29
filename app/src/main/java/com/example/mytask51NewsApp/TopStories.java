package com.example.mytask51NewsApp;

public class TopStories {

    private String headline, content;
    private int newsImage;
    private int id;

    public TopStories(int id, String headline, int newsImage) {
        this.id = id;
        this.headline = headline;
        this.newsImage = newsImage;

        //this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(int newsImage) {
        this.newsImage = newsImage;
    }

    public String getHeadline() {
        return headline;
    }

    public String getContent() {
        return content;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
