package com.gxg.administrator.mydemo7.pubuliuhead;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gxg.administrator.mydemo7.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyPubuliuActivity extends AppCompatActivity implements BaseRecycleView.LoadMoreListener {

    @Bind(R.id.base_list)
    BaseRecycleView mBaseList;
    @Bind(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    @Bind(R.id.activity_my_pubuliu)
    RelativeLayout mActivityMyPubuliu;

    private MyStaggeredGridLayoutManager staggeredGridLayoutManager;
    private MyPubuAdapter mAdapter;
    private Toast toast;

    private boolean mIsRefreshing=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pubuliu);
        ButterKnife.bind(this);

        initData();


    }

    private void initData() {
        mAdapter = new MyPubuAdapter(this);
        mAdapter.setData(getData());
        mAdapter.setListener(new BaseRecycleView.OnItemTouchListener() {
            @Override
            public void onClickListener(int position) {
                showToast(data.get(position));
            }

            @Override
            public void onLongClickListener(int position) {
                showToast(data.get(position));
            }
        });

        staggeredGridLayoutManager = new MyStaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mBaseList.setLayoutManager(staggeredGridLayoutManager);
        mBaseList.setLoadMoreListener(this);

        mBaseList.addHeaderView(getHeader());
        mBaseList.addFooterView(getLoadingBar());

        mBaseList.setAdapter(mAdapter);


        mSwipeLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW);
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mIsRefreshing=true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        mSwipeLayout.setRefreshing(false);
                        mBaseList.setAutoLoadMoreEnable(true);

                        mAdapter.clear();
                        data.clear();
                        data = null;
                        mAdapter.setData(getData());
                        mBaseList.getAdapter().notifyDataSetChanged();

                        mAdapter.notifyDataSetChanged();
                        mIsRefreshing=false;

                        Log.e("sss", "run:    "+mAdapter.getData().size() );

                    }
                }, 1000);
            }
        });


        mBaseList.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (mIsRefreshing) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
        );
    }

    private void showToast(String s) {
        if (toast == null)
            toast = Toast.makeText(this, s, Toast.LENGTH_SHORT);
        else
            toast.setText(s);
        toast.show();
    }

    private List<String> data;
    private List<String> getData() {
        Log.e("sss", "run:1111111111111 ");
        if (data == null)
            data = new ArrayList<>();
        Log.e("sss", "getData: "+data.size()+"  "+data.toString() );
        int size = data.size();
        for (int i = 1; i <= 20; i++) {
            data.add((size + i) + "");
        }

        return data;
    }

    private ProgressBar loadingBar;
    private ProgressBar getLoadingBar() {
        if (loadingBar == null) {
            loadingBar = new ProgressBar(this);
        }
        return loadingBar;
    }


    private TextView headerTxt;
    private TextView getHeader() {
        if (headerTxt == null) {
            headerTxt = new TextView(this);
            headerTxt.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 250));
            headerTxt.setGravity(Gravity.CENTER);
            headerTxt.setText("header view");
            headerTxt.setBackgroundColor(Color.YELLOW);
        }
        return headerTxt;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onLoadMore() {
        Log.e("sss", "run:加载更多00000000000000   "+mAdapter.getData().size());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e("sss", "run:加载更多 11111111111111    "+mAdapter.getData().size());
                mAdapter.setData(getData());
                mBaseList.notifyMoreFinish(true);
            }
        }, 2000);
    }
}
