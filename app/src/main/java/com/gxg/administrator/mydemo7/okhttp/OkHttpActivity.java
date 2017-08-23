package com.gxg.administrator.mydemo7.okhttp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.gxg.administrator.mydemo7.R;
import com.gxg.administrator.mydemo7.headscroll.adapter.FragmentScrollAdapter;
import com.gxg.administrator.mydemo7.headscroll.bean.HeadBean;
import com.gxg.administrator.mydemo7.headscroll.view.SuperSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OkHttpActivity extends AppCompatActivity {

    @Bind(R.id.rv)
    RecyclerView mRv;
    @Bind(R.id.swipe_layout)
    SuperSwipeRefreshLayout mSwipeLayout;
    private FragmentScrollAdapter mFragmentScrollAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
        ButterKnife.bind(this);

        HttpHelper.getInstance().request(HttpHelper.url, new HttpHelper.HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.e("sss  onSuccess", result);
            }

            @Override
            public void onFailure(String msg) {
                Log.e("sss  onFailure", msg);
            }

            @Override
            public void onError(String msg) {
                Log.e("sss  onError", msg);
            }
        });

        initData();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRv.setLayoutManager(linearLayoutManager);
        mFragmentScrollAdapter = new FragmentScrollAdapter(mHeadBeanList);
        mFragmentScrollAdapter.setEnableLoadMore(false);
        mRv.setAdapter(mFragmentScrollAdapter);

        listener();
    }

    private void listener() {
        mSwipeLayout.setFooterView(View.inflate(this,R.layout.loadmore_view,null));
        mSwipeLayout.setOnRefreshListener(new SuperSwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeLayout.setRefreshing(false);
                    }
                },1000);
            }

            @Override
            public void onPullDistance(int distance) {

            }

            @Override
            public void onPullEnable(boolean enable) {

            }
        });
        mSwipeLayout.setOnPushLoadMoreListener(new SuperSwipeRefreshLayout.OnPushLoadMoreListener() {
            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeLayout.setLoadMore(false);
                    }
                },1000);
            }

            @Override
            public void onPushDistance(int distance) {

            }

            @Override
            public void onPushEnable(boolean enable) {

            }
        });
    }

    private void initData() {
        for(int i = 0;i<20;i++){
            HeadBean headBean = new HeadBean();
            headBean.setName("测试"+i);
            mHeadBeanList.add(headBean);
        }
    }
    List<HeadBean> mHeadBeanList = new ArrayList<>();
}
