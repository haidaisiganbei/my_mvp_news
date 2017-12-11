package com.example.qwang.mvpnews01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.qwang.mvpnews01.Adapter.NewsListAdapter;
import com.example.qwang.mvpnews01.Model.NewsModel;
import com.example.qwang.mvpnews01.Presenter.NewsListPresenter;
import com.example.qwang.mvpnews01.View.IGetNewsListView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IGetNewsListView, NewsListAdapter.OnItemClickListener {
    private RecyclerView recyclerView;
    private NewsListPresenter newsListPresenter = new NewsListPresenter(this);
    private NewsListAdapter newsListAdapter;
    private List<NewsModel> newsModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }



    private void initView() {
        recyclerView = findViewById(R.id.rcv_news_list);
    }

    private void initData() {
        newsListPresenter.getNewsList();
    }
    @Override
    public void Success(List<NewsModel> newsModels) {
        this.newsModels = newsModels;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newsListAdapter = new NewsListAdapter(this,newsModels);
        newsListAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(newsListAdapter);
    }

    @Override
    public void Fail() {

    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(MainActivity.this,ContentActivity.class);
        intent.putExtra("url",newsModels.get(position).getUrl());
        startActivity(intent);
    }
}
