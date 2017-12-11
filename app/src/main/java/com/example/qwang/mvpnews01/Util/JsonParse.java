package com.example.qwang.mvpnews01.Util;

import com.example.qwang.mvpnews01.Model.NewsResponseModel;
import com.google.gson.Gson;

/**
 * Created by QWang on 2017/12/8.
 */

public class JsonParse implements IJsonData {
    String jsonData;

    public JsonParse(String jsonData) {
        this.jsonData = jsonData;
    }

    @Override
    public void parseToObject() {
        Gson gson = new Gson();
        NewsResponseModel newsResponseModel = gson.fromJson(jsonData,NewsResponseModel.class);
    }
}
