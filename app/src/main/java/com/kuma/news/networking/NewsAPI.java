package com.kuma.news.networking;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by Jorge.Enciso on 30/03/2017.
 */
public class NewsAPI {
    private final static String APIPATH = "https://newsapi.org/v1/";

    private static NewsService newsService = null;

    public static NewsService getApi() {
        if (newsService == null)
            return initNewsService();
        else
            return newsService;
    }

    private static NewsService initNewsService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIPATH)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
        return newsService = retrofit.create(NewsService.class);
    }

}