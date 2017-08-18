package com.gxg.administrator.mydemo7.iswiperefreshlayout;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gxg.administrator.mydemo7.R;
import com.gxg.administrator.mydemo7.headscroll.adapter.FragmentScrollAdapter;
import com.gxg.administrator.mydemo7.headscroll.bean.HeadBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class IRecycleviewActivity extends AppCompatActivity {

    @Bind(R.id.rv)
    RecyclerView mRv;
    @Bind(R.id.refresh_lv)
    ISwipeRefreshLayout mRefreshLv;
    private FragmentScrollAdapter mFragmentScrollAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_irecycleview);
        ButterKnife.bind(this);

        initData();

        mRefreshLv.setOnRefreshListener(new ISwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.e("sss", "onLoadMoreRequested: 下拉刷新");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("sss", "onLoadMoreRequested: 下拉刷新完成");
                        mRefreshLv.setRefreshing(false);
                    }
                },1000);
            }
        });


        mFragmentScrollAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                Log.e("sss", "onLoadMoreRequested: 加载更多");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("sss", "onLoadMoreRequested: 加载更多完成");
                       addData();

                    }
                },1000);
            }
        },mRv);

    }
    public void addData(){
        List<HeadBean> list = new ArrayList<>();
        HeadBean headBean = new HeadBean();
        headBean.setName("下拉item "+mFragmentScrollAdapter.getData().size());
        list.add(headBean);
        HeadBean headBean1 = new HeadBean();
        headBean1.setName("下拉item "+mFragmentScrollAdapter.getData().size()+1);
        list.add(headBean1);
        mFragmentScrollAdapter.addData(list);
        mFragmentScrollAdapter.loadMoreComplete();
    }


    List<HeadBean> mHeadBeanList = new ArrayList<>();
    private void initData() {
        for(int i = 0;i<20;i++){
            HeadBean headBean = new HeadBean();
            headBean.setName("下拉item "+i);
            mHeadBeanList.add(headBean);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRv.setLayoutManager(linearLayoutManager);
        mFragmentScrollAdapter = new FragmentScrollAdapter(mHeadBeanList);
        mRv.setAdapter(mFragmentScrollAdapter);
    }
}
