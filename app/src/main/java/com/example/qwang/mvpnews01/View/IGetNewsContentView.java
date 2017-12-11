package com.example.qwang.mvpnews01.View;

import com.example.qwang.mvpnews01.Model.NewsModel;

/**
 * Created by QWang on 2017/12/6.
 */

public interface IGetNewsContentView {
    void getNewsContentViewSuccess(NewsModel newsModel);
    void getNewsContentViewFail();
}
