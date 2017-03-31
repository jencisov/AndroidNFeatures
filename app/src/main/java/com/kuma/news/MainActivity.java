package com.kuma.news;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.kuma.news.databinding.ActivityMainBinding;
import com.kuma.news.model.GetArticlesResponse;
import com.kuma.news.networking.NewsAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.activityMainRecyclerview.setLayoutManager(new LinearLayoutManager(this));

        NewsAPI.getApi().getArticles("espn", "top").enqueue(new Callback<GetArticlesResponse>() {
            @Override public void onResponse(Call<GetArticlesResponse> call,
                                             Response<GetArticlesResponse> response) {
                handleResponse(response);
                showNewApiSnack();
            }

            @Override public void onFailure(Call<GetArticlesResponse> call, Throwable t) {
            }
        });
    }

    private void handleResponse(Response<GetArticlesResponse> response) {
        GetArticlesResponse getArticlesResponse = response.body();
        NewsStore.setArticles(getArticlesResponse.getArticles());
        HomeNewsAdapter homeNewsAdapter = new HomeNewsAdapter(NewsStore.getArticles());
        mBinding.activityMainRecyclerview.setAdapter(homeNewsAdapter);
    }

    private void showNewApiSnack() {
        Snackbar.make(mBinding.activityMain, "Powered by NewsApi.org", Snackbar.LENGTH_SHORT)
                .setAction("Visit", new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        loadNewsApiWebsite();
                    }
                }).show();
    }

    private void loadNewsApiWebsite() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://newsapi.org")));
    }

}