package com.example.mytask51NewsApp;

import android.widget.ImageView;

public class RelatedNews {
    private int image;
    private String headline;
    private int id;

    public RelatedNews(int id, int image, String headline) {
        this.id = id;
        this.image = image;
        this.headline = headline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }
    public String getHeadline() {
        return headline;
    }
    public void setHeadline(String headline) {
        this.headline = headline;
    }

}
