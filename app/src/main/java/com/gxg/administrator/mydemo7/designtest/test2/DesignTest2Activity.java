package com.gxg.administrator.mydemo7.designtest.test2;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.gxg.administrator.mydemo7.R;
import com.gxg.administrator.mydemo7.designtest.DesignAdapter;
import com.gxg.administrator.mydemo7.designtest.DesignBasebean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DesignTest2Activity extends AppCompatActivity {


    List<DesignBasebean> mList = new ArrayList<>();
    @Bind(R.id.back)
    ImageView mBack;
    @Bind(R.id.title)
    TextView mTitle;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.appbar_layout)
    AppBarLayout mAppbarLayout;
    @Bind(R.id.rv)
    RecyclerView mRv;
    @Bind(R.id.toolbar_title)
    TextView mToolbarTitle;
    @Bind(R.id.fab)
    FloatingActionButton mFab;
    @Bind(R.id.activity_design_test2)
    CoordinatorLayout mActivityDesignTest2;
    private DesignAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_test2);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    private void initView() {


        mRv.setLayoutManager(new GridLayoutManager(this, 2));
        mAdapter = new DesignAdapter(new ArrayList<DesignBasebean>());
        mRv.setAdapter(mAdapter);
    }

    private void initData() {
        for (int i = 0; i < 30; i++) {
            DesignBasebean basebean = new DesignBasebean();
            basebean.setName("测试" + i);
            basebean.setImg(R.drawable.auto_header);
            mList.add(basebean);
        }
        mAdapter.addData(mList);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
