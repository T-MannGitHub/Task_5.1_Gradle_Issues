package com.example.mytask51NewsApp;

public class News {

    private String headline, content;
    private int id;

    public News(int id, String headline, String content) {
        this.id = id;
        this.headline = headline;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
