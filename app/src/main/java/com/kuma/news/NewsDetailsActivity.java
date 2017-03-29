package com.kuma.news;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.kuma.news.databinding.ActivityNewsDetailsBinding;
import com.kuma.news.model.NewsArticle;


public class NewsDetailsActivity extends AppCompatActivity {
    public static final String KEY_INDEX = "news_index";

    ActivityNewsDetailsBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_news_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int index = getIntent().getIntExtra(KEY_INDEX, -1);
        if (index != -1)
            updateNewsDetails(index);
        else
            Toast.makeText(NewsDetailsActivity.this, "Sorry, ibncorrect index passed", Toast.LENGTH_SHORT).show();
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateNewsDetails(int index) {
        mBinding.activityNewsDetailsWebview.getSettings().setJavaScriptEnabled(true);
        mBinding.activityNewsDetailsWebview.setWebViewClient(new WebViewClient() {
            @Override public void onPageStarted(WebView view, String url, Bitmap favicon) {
                mBinding.activityNewsDetailsProgressbar.setVisibility(View.VISIBLE);
            }

            @Override public void onPageFinished(WebView view, String url) {
                mBinding.activityNewsDetailsProgressbar.setVisibility(View.GONE);
            }

            @Override public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                mBinding.activityNewsDetailsProgressbar.setVisibility(View.GONE);
                Toast.makeText(NewsDetailsActivity.this, "Error in loading webpage", Toast.LENGTH_SHORT).show();
            }
        });
        final NewsArticle newsArticle = NewsStore.getNewsArticles().get(index);
        mBinding.activityNewsDetailsWebview.loadUrl(newsArticle.getUrlToArticle());
        getSupportActionBar().setTitle(newsArticle.getTitle());
    }

    public static void launch(Context context, int index) {
        Intent intent = new Intent(context, NewsDetailsActivity.class);
        intent.putExtra(KEY_INDEX, index);
        context.startActivity(intent);
    }

}