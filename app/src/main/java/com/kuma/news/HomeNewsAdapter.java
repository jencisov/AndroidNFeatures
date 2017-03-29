package com.kuma.news;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kuma.news.databinding.ItemHomeNewsBinding;
import com.kuma.news.model.NewsArticle;

import java.util.List;

/**
 * Created by Jorge.Enciso on 28/03/2017.
 */
public class HomeNewsAdapter extends RecyclerView.Adapter<HomeNewsAdapter.HomeNewsViewHolder> {
    private List<NewsArticle> newsArticleList;

    public HomeNewsAdapter(List<NewsArticle> newsArticleList) {
        this.newsArticleList = newsArticleList;
    }

    @Override public HomeNewsAdapter.HomeNewsViewHolder onCreateViewHolder(ViewGroup parent,
                                                                           int viewType) {
        ItemHomeNewsBinding binding =
                ItemHomeNewsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new HomeNewsViewHolder(binding);
    }

    @Override public void onBindViewHolder(final HomeNewsAdapter.HomeNewsViewHolder holder, final int position) {
        final NewsArticle newsArticle = newsArticleList.get(position);
        final View root = holder.getBinding().getRoot();

        bindNews(holder, position, newsArticle, root);
    }

    private void bindNews(HomeNewsViewHolder holder, final int position, NewsArticle newsArticle, View root) {
        Glide.with(root.getContext())
                .load(newsArticle.getImageUrl())
                .centerCrop()
                .into((ImageView) root.findViewById(R.id.card_news_image));
        holder.getBinding().setVariable(BR.newsArticle, newsArticle);
        root.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                NewsDetailsActivity.launch(v.getContext(), position);
            }
        });
        holder.getBinding().executePendingBindings();
    }

    @Override public int getItemCount() {
        return newsArticleList != null ? newsArticleList.size() : 0;
    }

    static class HomeNewsViewHolder extends RecyclerView.ViewHolder {
        private final ItemHomeNewsBinding binding;

        public HomeNewsViewHolder(ItemHomeNewsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public ViewDataBinding getBinding() {
            return binding;
        }

    }

}