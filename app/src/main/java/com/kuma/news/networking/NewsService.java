package com.kuma.news.networking;

import com.kuma.news.model.GetArticlesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jorge.Enciso on 30/03/2017.
 */
public interface NewsService {
    String APIKEY = "e133f30d39864545b294516559acf35e";

    @GET("articles?apiKey=" + APIKEY)
    Call<GetArticlesResponse> getArticles(
            @Query("source") String source,
            @Query("sortBy") String sortBy
    );

}
