package com.example.qwang.mvpnews01.Model;


import java.util.List;

/**
 * Created by QWang on 2017/12/6.
 */

public class NewsResponseModel {
    private String status;
    private String msg;
    public Result result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public class Result {
        private String channel;
        private int num;
        private List<NewsModel> list;

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public List<NewsModel> getList() {
            return list;
        }

        public void setList(List<NewsModel> list) {
            this.list = list;
        }
    }
}
