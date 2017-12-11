package com.example.qwang.mvpnews01.Util;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by QWang on 2017/12/8.
 */

public class okhttp implements Iokhttp{
    private String url;
    private Response response;
    private android.os.Handler mHandler = new android.os.Handler();

    public okhttp(String url) {
        this.url = url;
    }

    public void getHttp(){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.code()==200){
                    IJsonData obj = new JsonParse(response.body().string());
                }

            }
        });

    }


    @Override
    public void getHttp(IokhttpListener iokhttpListener) {

    }

    @Override
    public void getHttpSuccess(Response response) {

    }

    @Override
    public void getHttpFail() {

    }
}
