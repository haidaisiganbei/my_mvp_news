package com.example.qwang.mvpnews01.Biz;

import com.example.qwang.mvpnews01.Model.NewsModel;

import java.util.List;

/**
 * Created by QWang on 2017/12/6.
 */

public interface IGetNewsListListener {
    void getNewsListSuccess(List<NewsModel> NewsModels);
    void getNewsListFail();
}
