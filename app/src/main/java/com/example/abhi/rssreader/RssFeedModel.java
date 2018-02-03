package com.example.abhi.rssreader;

/**
 * Created by abhi on 2/2/18.
 */

public class RssFeedModel {
    public String title;
    public String link;
    public String description;

    public RssFeedModel(String title, String link, String description) {
        this.title = title;
        this.link = link;
        this.description = description;
    }
}
