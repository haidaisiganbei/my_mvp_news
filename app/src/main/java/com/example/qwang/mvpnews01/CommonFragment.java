package com.example.qwang.mvpnews01;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qwang.mvpnews01.Adapter.NewsListAdapter;
import com.example.qwang.mvpnews01.Model.NewsModel;
import com.example.qwang.mvpnews01.Presenter.NewsListPresenter;
import com.example.qwang.mvpnews01.View.IGetNewsListView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CommonFragment extends Fragment implements IGetNewsListView, NewsListAdapter.OnItemClickListener{
    private RecyclerView recyclerView;
    private NewsListPresenter newsListPresenter = new NewsListPresenter(this);
    private NewsListAdapter newsListAdapter;
    private List<NewsModel> newsModels;

    public CommonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        initData();
    }

    private void initView() {
        recyclerView = getActivity().findViewById(R.id.rcv_news_list);
    }

    private void initData() {
        newsListPresenter.getNewsList();
    }
    @Override
    public void Success(List<NewsModel> newsModels) {
        this.newsModels = newsModels;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        newsListAdapter = new NewsListAdapter(this.getContext(),newsModels);
       newsListAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(newsListAdapter);
    }



    @Override
    public void Fail() {

    }


    @Override
    public void onClick(int position) {
        Intent intent = new Intent(this.getContext(),ContentActivity.class);
        intent.putExtra("url",newsModels.get(position).getUrl());
        startActivity(intent);
    }


}
