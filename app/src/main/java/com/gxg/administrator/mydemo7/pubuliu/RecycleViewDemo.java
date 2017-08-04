package com.gxg.administrator.mydemo7.pubuliu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import com.ajguan.library.EasyRefreshLayout;
import com.gxg.administrator.mydemo7.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecycleViewDemo extends AppCompatActivity {

    @Bind(R.id.rv)
    RecyclerView mRv;
    @Bind(R.id.erl)
    EasyRefreshLayout mErl;

    private List<ImgBean> mImgBeanList = new ArrayList<>();
    private View mHeadview;
    private View mFootview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_demo);
        ButterKnife.bind(this);

        mHeadview = View.inflate(this, R.layout.head_view, null);
        mFootview = View.inflate(this, R.layout.foot_view, null);
        initData();

        initView();
    }

    private void initView() {

        mRv.setPadding(8, 8, 8, 8);
        mRv.setHasFixedSize(true);
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mRv.setLayoutManager(layoutManager);

        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        SpacesItemDecoration decoration = new SpacesItemDecoration(8);

        mRv.addItemDecoration(decoration);


        final MyAdapter adapter = new MyAdapter(mImgBeanList);
        mRv.setAdapter(adapter);


        adapter.addHeaderView(mHeadview);
        adapter.addFooterView(mFootview);

        mRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                layoutManager.invalidateSpanAssignments(); //防止第一行到顶部有空白区域
            }

        });
        mErl.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {
                mRv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(RecycleViewDemo.this, "加载更多", Toast.LENGTH_LONG).show();
                        mErl.loadMoreComplete();
                    }
                }, 1000);
            }

            @Override
            public void onRefreshing() {
                mRv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(RecycleViewDemo.this, "下拉加载", Toast.LENGTH_LONG).show();
                        mErl.refreshComplete();
                    }
                }, 1000);
            }
        });


    }

    private void initData() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        RecycleViewDemo.this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;

//        int width = getWindowManager().getDefaultDisplay().getWidth();
        for (int i = 0; i < 30; i++) {
            ImgBean imgBean = new ImgBean();
            imgBean.setImg(R.drawable.yidian_1167278123);
            imgBean.setWidth(width);
            imgBean.setHeight((int) (200 + Math.random() * 200));
            mImgBeanList.add(imgBean);
        }
    }
}
