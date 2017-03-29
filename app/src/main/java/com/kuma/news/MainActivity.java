package com.kuma.news;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.kuma.news.databinding.ActivityMainBinding;
import com.kuma.news.model.NewsArticle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        List<NewsArticle> newsArticles = new ArrayList<>();
        newsArticles.add(new NewsArticle("Title", "Details",
                "http://trome.pe/files/modulo_entero1x1/files/crop/uploads/2017/03/27/58d9b34bcc3f6.r_1490715466659.0-0-341-400.jpeg", "Today",
                "http://trome.pe/deportes/seleccion-peruana/peru-vs-uruguay-vivo-directo-online-tv-eliminatorias-rusia-2018-44611"));
        newsArticles.add(new NewsArticle("Title", "Details",
                "http://trome.pe/files/modulo_entero2x1/uploads/2017/03/28/58dae729c1543.jpeg", "Today",
                "http://trome.pe/deportes/futbol-internacional/chile-vs-venezuela-vivo-directo-online-tv-eliminatorias-rusia-2018-44602"));
        NewsStore.setNewsArticles(newsArticles);

        HomeNewsAdapter homeNewsAdapter = new HomeNewsAdapter(NewsStore.getNewsArticles());
        binding.activityMainRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.activityMainRecyclerview.setAdapter(homeNewsAdapter);
    }

}