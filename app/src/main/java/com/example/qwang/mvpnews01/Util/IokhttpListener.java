package com.example.qwang.mvpnews01.Util;

import okhttp3.Response;

/**
 * Created by QWang on 2017/12/8.
 */

public interface IokhttpListener {
    void getHttpSuccess(Response response);
    void getHttpFail();
}
