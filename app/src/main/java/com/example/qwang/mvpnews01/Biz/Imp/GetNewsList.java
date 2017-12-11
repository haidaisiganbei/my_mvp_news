package com.example.qwang.mvpnews01.Biz.Imp;

import com.example.qwang.mvpnews01.Biz.IGetNewsList;
import com.example.qwang.mvpnews01.Biz.IGetNewsListListener;
import com.example.qwang.mvpnews01.Model.NewsResponseModel;
import com.example.qwang.mvpnews01.Util.Iokhttp;
import com.example.qwang.mvpnews01.Util.IokhttpListener;
import com.example.qwang.mvpnews01.Util.okhttp;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.qwang.mvpnews01.Config.Config.HOTLINES;

/**
 * Created by QWang on 2017/12/6.
 */

public class GetNewsList implements IGetNewsList {
    private android.os.Handler mHandler = new android.os.Handler();
    @Override
    public void getNewsList(final IGetNewsListListener iGetNewsListListener) {
//         Iokhttp http = new okhttp(new String());
//         http.getHttp(new IokhttpListener() {
//             @Override
//             public void getHttpSuccess(Response response) {
//
//             }
//
//             @Override
//             public void getHttpFail() {
//
//             }
//         });

        final Gson gson = new Gson();
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(HOTLINES).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText = response.body().string();
                if (response.code()==200){
                    final NewsResponseModel newsResponseModel = gson.fromJson(responseText,NewsResponseModel.class);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            iGetNewsListListener.getNewsListSuccess(newsResponseModel.result.getList());
                        }
                    });

                }else {
                    iGetNewsListListener.getNewsListFail();
                }
            }
        });
    }
}
