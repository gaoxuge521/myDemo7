package com.gxg.administrator.mydemo7.alivlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.gxg.administrator.mydemo7.R;
import com.gxg.administrator.mydemo7.pubuliu.ImgBean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AliVLayoutActivity extends AppCompatActivity {

    @Bind(R.id.rv_ali)
    RecyclerView mRvAli;
    @Bind(R.id.activity_ali_vlayout)
    RelativeLayout mActivityAliVlayout;
    private List<ImgBean> mImgBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ali_vlayout);
        ButterKnife.bind(this);
        initData();


        initRecycle();



    }

    private void initRecycle() {
        //设置Adapter列表
        List<DelegateAdapter.Adapter> adapters = new LinkedList<>();
        //绑定VirtualLayoutManager
        VirtualLayoutManager  layoutManager = new VirtualLayoutManager(this);
        mRvAli.setLayoutManager(layoutManager);


        StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper(3);
        staggeredGridLayoutHelper.setGap(20);

        VlayoutAdapter adapter = new VlayoutAdapter(this,mImgBeanList,staggeredGridLayoutHelper);
        adapters.add(adapter);


        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager);
        delegateAdapter.setAdapters(adapters);
        mRvAli.setAdapter(delegateAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }


    private void initData() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        AliVLayoutActivity.this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        for (int i = 0; i < 30; i++) {
            ImgBean imgBean = new ImgBean();
            imgBean.setName("测试"+i);
            imgBean.setImg(R.drawable.yidian_1167278026);
            imgBean.setWidth(width);
            imgBean.setHeight((int) (200 + Math.random() * 200));
            mImgBeanList.add(imgBean);
        }
    }
}
