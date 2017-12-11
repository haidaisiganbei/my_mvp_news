package com.example.qwang.mvpnews01.Presenter;

import android.os.Handler;

import com.example.qwang.mvpnews01.Biz.IGetNewsList;
import com.example.qwang.mvpnews01.Biz.IGetNewsListListener;
import com.example.qwang.mvpnews01.Biz.Imp.GetNewsList;
import com.example.qwang.mvpnews01.Model.NewsModel;
import com.example.qwang.mvpnews01.View.IGetNewsListView;

import java.util.List;

/**
 * Created by QWang on 2017/12/6.
 */

public class NewsListPresenter {
    private IGetNewsList getNewsListBiz;
    private IGetNewsListView getNewsListView;
    private Handler mHandler = new Handler();

    public NewsListPresenter(IGetNewsListView getNewsListView) {
        this.getNewsListView = getNewsListView;
        this.getNewsListBiz = new GetNewsList();
    }

    public void getNewsList(){
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                getNewsListBiz.getNewsList(new IGetNewsListListener() {
                    @Override
                    public void getNewsListSuccess(List<NewsModel> NewsModels) {
                        getNewsListView.Success(NewsModels);
                    }

                    @Override
                    public void getNewsListFail() {
                        getNewsListView.Fail();
                    }
                });
            }
        });
    }

}
