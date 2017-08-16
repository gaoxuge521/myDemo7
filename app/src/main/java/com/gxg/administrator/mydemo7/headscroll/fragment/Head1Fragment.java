package com.gxg.administrator.mydemo7.headscroll.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        FragmentScrollAdapter fragmentScrollAdapter = new FragmentScrollAdapter(mHeadBeanList);
        mFragment_rv.setAdapter(fragmentScrollAdapter);
    }

    @Override
    public View getScrollableView() {
        return mFragment_rv;
    }
}
