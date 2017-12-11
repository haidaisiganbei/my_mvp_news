package com.example.qwang.mvpnews01.Config;

/**
 * Created by QWang on 2017/12/1.
 */

public class Config {
//       服务器地址
    public static final String HOST = "http://api.jisuapi.com/";
//    appkey = 033339c7dd8a8e5f
//  头条新闻接口
    public static final String HOTLINES = "http://api.jisuapi.com/news/get?channel=头条&start=0&num=40&appkey=033339c7dd8a8e5f";

//    获取新闻频道接口地址http://api.jisuapi.com/news/channel
    public static final String CHANNEL = "http://api.jisuapi.com/news/channel?appkey=033339c7dd8a8e5f";
//    搜索新闻接口地址http://api.jisuapi.com/news/search
//  "http://api.jisuapi.com/news/search?keyword=姚明&appkey=033339c7dd8a8e5f";
    public static  String Search(String word){
        return "http://api.jisuapi.com/news/search?keyword="+word+"&appkey=033339c7dd8a8e5f";
    }
}
