package com.example.qwang.mvpnews01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.qwang.mvpnews01.Model.NewsModel;
import com.example.qwang.mvpnews01.View.IGetNewsContentView;

public class ContentActivity extends AppCompatActivity implements IGetNewsContentView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        WebView mContent = findViewById(R.id.wv_content);
        mContent.getSettings().setJavaScriptEnabled(true);
        mContent.loadUrl(url);
        mContent.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

    }

    @Override
    public void getNewsContentViewSuccess(NewsModel newsModel) {

    }

    @Override
    public void getNewsContentViewFail() {

    }
}
