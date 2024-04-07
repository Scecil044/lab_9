package com.example.lab_9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ArticleAdapter extends BaseAdapter {

    private Context context;
    private List<Article> articles;

    public ArticleAdapter(Context context, List<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    @Override
    public int getCount() {
        return articles.size();
    }

    @Override
    public Object getItem(int position) {
        return articles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false);
        }

        Article article = articles.get(position);

        TextView titleTextView = convertView.findViewById(android.R.id.text1);
        TextView sectionTextView = convertView.findViewById(android.R.id.text2);

        titleTextView.setText(article.getTitle());
        sectionTextView.setText(article.getSectionName());

        return convertView;
    }

    // Clear method
    public void clear() {
        articles.clear();
        notifyDataSetChanged();
    }

    // AddAll method
    public void addAll(List<Article> articles) {
        this.articles.addAll(articles);
        notifyDataSetChanged();
    }
}

