package com.kuma.news;

import com.kuma.news.model.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorge.Enciso on 28/03/2017.
 */
public class NewsStore {
    private static List<Article> articleList = new ArrayList<>();

    public static void setArticles(List<Article> list) {
        articleList = list;
    }

    public static List<Article> getArticles() {
        return articleList;
    }

}