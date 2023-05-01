package com.example.mytask51NewsApp;

import android.graphics.drawable.Drawable;

public class News {

    private String subHeading, content;
    private int newsImage;

    private int id;

    public News(int id, String subHeading, String content, int newsImage) {

        this.id = id;
        this.subHeading = subHeading;
        this.content = content;
        this.newsImage = newsImage;

    }

    public int getId() {
        return id;
    }

    public String getSubHeading() {
        return subHeading;
    }

    public String getContent() {
        return content;
    }

    public int getNewsImage() { return newsImage;}

    public void setId(int id) {
        this.id = id;
    }

    public void setSubHeading(String subHeading) {
        this.subHeading = subHeading;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setNewsImage(int newsImage) {
        this.newsImage = newsImage;
    }
}
