package com.example.qwang.mvpnews01.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.qwang.mvpnews01.Model.NewsModel;
import com.example.qwang.mvpnews01.R;


import java.util.List;

/**
 * Created by QWang on 2017/12/6.
 */

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsListViewHolder>{
    private Context mContext;
    private List<NewsModel> newsModels;
    private OnItemClickListener mOnItemClickListener = null;
    public NewsListAdapter(Context mContext, List<NewsModel> newsModels) {
        this.mContext = mContext;
        this.newsModels = newsModels;
    }



    public interface OnItemClickListener{
        void onClick( int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this. mOnItemClickListener=onItemClickListener;
    }



    @Override
    public NewsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater. from(mContext).inflate(R.layout.news_item,parent,false);
        NewsListViewHolder holder= new NewsListViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(NewsListViewHolder holder, final int position) {
        NewsModel item = newsModels.get(position);

        Glide.with(mContext).load(item.getPic()).into(holder.getIv_pic());
        holder.getTv_title().setText(item.getTitle());
        holder.getTv_src().setText(item.getSrc());
        holder.getTv_time().setText(item.getTime());

        if (mOnItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onClick(position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return newsModels.size();
    }

    public class NewsListViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_pic;
        private TextView tv_title;
        private TextView tv_src;
        private TextView tv_time;

        public ImageView getIv_pic() {
            return iv_pic;
        }

        public void setIv_pic(ImageView iv_pic) {
            this.iv_pic = iv_pic;
        }

        public TextView getTv_title() {
            return tv_title;
        }

        public void setTv_title(TextView tv_title) {
            this.tv_title = tv_title;
        }

        public TextView getTv_src() {
            return tv_src;
        }

        public void setTv_src(TextView tv_src) {
            this.tv_src = tv_src;
        }

        public TextView getTv_time() {
            return tv_time;
        }

        public void setTv_time(TextView tv_time) {
            this.tv_time = tv_time;
        }

        public NewsListViewHolder(View itemView) {
            super(itemView);

            iv_pic = itemView.findViewById(R.id.iv_news);
            tv_title = itemView.findViewById(R.id.tv_news_title);
            tv_src = itemView.findViewById(R.id.tv_news_src);
            tv_time = itemView.findViewById(R.id.tv_news_time);
        }
    }
}
