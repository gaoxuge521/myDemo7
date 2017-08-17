package com.gxg.administrator.mydemo7.headscroll.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.gxg.administrator.mydemo7.R;
import com.gxg.administrator.mydemo7.headscroll.adapter.FragmentScrollAdapter;
import com.gxg.administrator.mydemo7.headscroll.bean.HeadBean;
import com.gxg.administrator.mydemo7.headscroll.view.HeaderViewPagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaoxuge on 2017/8/16 at 19:12.
 *
 */

public class Head1Fragment extends HeaderViewPagerFragment{

    private View mView;
    private RecyclerView mFragment_rv;
    private String mName;
    private FragmentScrollAdapter mFragmentScrollAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_head,null);
        return mView;

    }

    public static Head1Fragment newInstance(String name){
        Bundle bundle = new Bundle();
        bundle.putString("name",name);
        Head1Fragment fragment = new Head1Fragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFragment_rv = (RecyclerView) mView.findViewById(R.id.fragment_rv);
        initData();

        listener();
    }

    private void listener() {
        mFragment_rv.addOnItemTouchListener(new OnItemClickListener() {

            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.item_fm_iv:
                        Toast.makeText(getActivity(),"点击了图片"+position,Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            //这两个点击事件都可以
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Toast.makeText(getActivity(),"点击了条目  "+position,Toast.LENGTH_SHORT).show();
//            }

            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getActivity(),"点击了条目~~"+position,Toast.LENGTH_SHORT).show();
//
            }
        });
    }


    List<HeadBean> mHeadBeanList = new ArrayList<>();
    private void initData() {
        Bundle arguments = getArguments();
        if(arguments!=null){
            mName = arguments.getString("name");

        }

        Log.e("sss", "initData: "+mName );

        for(int i = 0;i<20;i++){
            HeadBean headBean = new HeadBean();
            headBean.setName(mName+i);
            mHeadBeanList.add(headBean);
        }


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mFragment_rv.setLayoutManager(linearLayoutManager);
        mFragmentScrollAdapter = new FragmentScrollAdapter(mHeadBeanList);
        mFragment_rv.setAdapter(mFragmentScrollAdapter);

        mFragmentScrollAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        addData();
                    }
                },1000);
            }
        });
    }

    public void addData(){
        int size = mFragmentScrollAdapter.getData().size();
        if(size>=24){
            View view = View.inflate(getActivity(),R.layout.headscroll_foot_view,null);
            mFragmentScrollAdapter.addFooterView(view);
            mFragmentScrollAdapter.loadMoreComplete();
            mFragmentScrollAdapter.setEnableLoadMore(false);
        }else{
            List<HeadBean> list = new ArrayList<>();
            HeadBean headBean = new HeadBean();
            headBean.setName(mName+size);
            list.add(headBean);
            mFragmentScrollAdapter.addData(list);
            mFragmentScrollAdapter.loadMoreComplete();
        }

    }

    @Override
    public View getScrollableView() {
        return mFragment_rv;
    }
}
