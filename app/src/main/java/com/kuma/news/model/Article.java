package com.kuma.news.model;

import com.kuma.news.utils.DateUtils;
import com.squareup.moshi.Json;

public class Article {
    @Json(name = "author")
    private String author;
    @Json(name = "title")
    private String title;
    @Json(name = "description")
    private String description;
    @Json(name = "url")
    private String url;
    @Json(name = "urlToImage")
    private String urlToImage;
    @Json(name = "publishedAt")
    private String publishedAt;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return DateUtils.formatNewsApiDate(publishedAt);
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

}