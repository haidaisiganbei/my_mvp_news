package com.example.qwang.mvpnews01;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.qwang.mvpnews01.Adapter.MyFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class IndexActivity extends AppCompatActivity {

    private static final String TAG ="IndexActivity" ;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    public static final String[] TITLES = {"头条", "新闻", "财经", "体育", "娱乐", "军事", "教育",
            "科技", "NBA", "股票", "星座", "女性", "健康", "育儿"};
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        mViewPager = findViewById(R.id.vp_view);
        mTabLayout = findViewById(R.id.tabs);

//      数据源FragmentList
        fragmentList = new ArrayList<>();
        fragmentList.add(new CommonFragment());
        fragmentList.add(new CommonFragment());
//      数据源titleList
        mTitleList.add("头条");
        mTitleList.add("新闻");

//      适配器adapter
        MyFragmentPagerAdapter mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList, mTitleList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected: "+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
