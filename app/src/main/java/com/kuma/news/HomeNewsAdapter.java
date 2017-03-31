package com.kuma.news;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kuma.news.databinding.ItemHomeNewsBinding;
import com.kuma.news.model.Article;

import java.util.List;

/**
 * Created by Jorge.Enciso on 28/03/2017.
 */
public class HomeNewsAdapter extends RecyclerView.Adapter<HomeNewsAdapter.HomeNewsViewHolder> {
    private List<Article> articleList;

    public HomeNewsAdapter(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override public HomeNewsAdapter.HomeNewsViewHolder onCreateViewHolder(ViewGroup parent,
                                                                           int viewType) {
        ItemHomeNewsBinding binding =
                ItemHomeNewsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new HomeNewsViewHolder(binding);
    }

    @Override public void onBindViewHolder(final HomeNewsAdapter.HomeNewsViewHolder holder, final int position) {
        final Article article = articleList.get(position);
        final View root = holder.getBinding().getRoot();

        bindNews(holder, position, article, root);
    }

    private void bindNews(HomeNewsViewHolder holder, final int position, Article article, View root) {
        Glide.with(root.getContext())
                .load(article.getUrlToImage())
                .centerCrop()
                .into((ImageView) root.findViewById(R.id.card_news_image));
        holder.getBinding().setVariable(BR.article, article);
        root.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(v.getContext());
                Bundle bundle = new Bundle();
                bundle.putString("index", String.valueOf(position));
                firebaseAnalytics.logEvent("cardClicked", bundle);
                NewsDetailsActivity.launch(v.getContext(), position);
            }
        });
        holder.getBinding().executePendingBindings();
    }

    @Override public int getItemCount() {
        return articleList != null ? articleList.size() : 0;
    }

    static class HomeNewsViewHolder extends RecyclerView.ViewHolder {
        private final ItemHomeNewsBinding binding;

        HomeNewsViewHolder(ItemHomeNewsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        ViewDataBinding getBinding() {
            return binding;
        }

    }

}