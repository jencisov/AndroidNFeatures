package com.kuma.news;

import com.kuma.news.model.NewsArticle;

import java.util.List;

/**
 * Created by Jorge.Enciso on 28/03/2017.
 */
public class NewsStore {
    static List<NewsArticle> articleList;

    public static void setNewsArticles(List<NewsArticle> list) {
        articleList = list;
    }

    public static List<NewsArticle> getNewsArticles() {
        return articleList;
    }

}