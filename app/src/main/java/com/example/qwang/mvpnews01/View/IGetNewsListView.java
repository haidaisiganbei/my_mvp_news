package com.example.qwang.mvpnews01.View;

import com.example.qwang.mvpnews01.Model.NewsModel;

import java.util.List;

/**
 * Created by QWang on 2017/12/6.
 */

public interface IGetNewsListView {
    void Success(List<NewsModel> newsModels);
    void Fail();
}
