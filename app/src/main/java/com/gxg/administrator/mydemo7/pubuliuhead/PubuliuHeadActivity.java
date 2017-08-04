package com.gxg.administrator.mydemo7.pubuliuhead;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gxg.administrator.mydemo7.R;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PubuliuHeadActivity extends AppCompatActivity   implements View.OnClickListener, BaseRecycleView.LoadMoreListener{

    private Toolbar toolbar;
    private SwipeRefreshLayout swipeLayout;
    private BaseRecycleView baseRecycleView;
    private MyAdapter adapter;
    private List<String> data;
    private ProgressBar loadingBar;
    private TextView headerTxt;

    private Toast toast;

    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    private List<Integer> specialItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pubuliu_head);
        init();
    }
    private void init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_layout);
        baseRecycleView = (BaseRecycleView) findViewById(R.id.base_list);

        toolbar.setSubtitle("BaseRecyclerViewDemo");
        toolbar.inflateMenu(R.menu.toolbar_menu);
        toolbar.setOnMenuItemClickListener(new MenuItemClickListener());

        adapter = new MyAdapter(this);
        adapter.setData(getData());
        adapter.setListener(new MyItemTouchListener());

        linearLayoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new GridLayoutManager(this, 3);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        baseRecycleView.addHeaderView(getHeader());
        baseRecycleView.addFooterView(getLoadingBar());
        baseRecycleView.setLoadMoreListener(this);
        baseRecycleView.setLayoutManager(linearLayoutManager);
        baseRecycleView.setAdapter(adapter);

        swipeLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW);
        swipeLayout.setOnRefreshListener(new MyRefreshListener());
    }

    private List<String> getData() {
        if (data == null)
            data = new ArrayList<>();
        int size = data.size();
        for (int i = 1; i <= 20; i++) {
            data.add((size + i) + "");
            if ((size+i) % 4 == 0) {
                specialItems.add(data.size() - 1);
            }
        }
        baseRecycleView.setSpecialItem(specialItems);
        return data;
    }

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

    private ProgressBar getLoadingBar() {
        if (loadingBar == null) {
            loadingBar = new ProgressBar(this);
        }
        return loadingBar;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar:
                break;
        }
    }

    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.setData(getData());
                baseRecycleView.notifyMoreFinish(true);
            }
        }, 2000);
    }

    private class MyAdapter extends RecyclerView.Adapter {

        private List<String> mData;
        private Context mContext;
        private LinearViewHolder lholder;
        private GridViewHolder gholder;
        private StaggeredViewHolder sholder;
        private SpecialViewHolder specialHolder;
        private BaseRecycleView.OnItemTouchListener mListener;
        private Map<Integer, Integer> staggeredData = new HashMap<>();

        public MyAdapter(Context context) {
            mContext = context;
        }

        public void setData(List<String> data) {
            mData = data;
        }

        public void setListener(BaseRecycleView.OnItemTouchListener listener) {
            mListener = listener;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == BaseRecycleView.TYPE_NORMAL) {
                lholder = new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_linear_view, parent, false));
                return lholder;
            } else if (viewType == BaseRecycleView.TYPE_GRID) {
                gholder = new GridViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_grid_view, parent, false));
                return gholder;
            } else if (viewType == BaseRecycleView.TYPE_STAGGERED) {
                sholder = new StaggeredViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_staggered_view, parent, false));
                return sholder;
            } else {
                specialHolder = new SpecialViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_special_view, parent, false));
                return specialHolder;
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof LinearViewHolder) {
                lholder = (LinearViewHolder) holder;
                lholder.position = position;
                lholder.txt.setText(mData.get(position));
            } else if (holder instanceof GridViewHolder) {
                gholder = (GridViewHolder) holder;
                gholder.position = position;
                gholder.txt.setText(mData.get(position));
            } else if (holder instanceof StaggeredViewHolder) {
                sholder = (StaggeredViewHolder) holder;
                sholder.position = position;
                sholder.txt.setText(mData.get(position));
                if (!staggeredData.containsKey(position))
                    staggeredData.put(position, (int) (Math.random() * 100 + 101));//记住高度
                sholder.txt.setMinHeight(staggeredData.get(position));
            } else if (holder instanceof SpecialViewHolder) {
                specialHolder = (SpecialViewHolder) holder;
                specialHolder.position = position;
                specialHolder.txt.setText("特殊view "+mData.get(position));
            }
        }

        @Override
        public int getItemCount() {
            return mData == null ? 0 : mData.size();
        }

        private class LinearViewHolder extends BaseRecycleView.BaseViewHolder {

            private TextView txt;

            public LinearViewHolder(View itemView) {
                super(itemView, mListener);
                txt = (TextView) itemView.findViewById(R.id.txt);
            }
        }

        private class GridViewHolder extends BaseRecycleView.BaseViewHolder {

            private TextView txt;

            public GridViewHolder(View itemView) {
                super(itemView, mListener);
                txt = (TextView) itemView.findViewById(R.id.txt);
            }
        }

        private class StaggeredViewHolder extends BaseRecycleView.BaseViewHolder {

            private TextView txt;

            public StaggeredViewHolder(View itemView) {
                super(itemView, mListener);
                txt = (TextView) itemView.findViewById(R.id.txt);
            }
        }

        private class SpecialViewHolder extends BaseRecycleView.BaseViewHolder {

            private TextView txt;

            public SpecialViewHolder(View itemView) {
                super(itemView, mListener);
                txt = (TextView) itemView.findViewById(R.id.txt);
            }
        }
    }

    private class MyRefreshListener implements SwipeRefreshLayout.OnRefreshListener {
        @Override
        public void onRefresh() {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    swipeLayout.setRefreshing(false);
                    data = null;
                    adapter.setData(getData());
                    adapter.notifyDataSetChanged();
                }
            }, 2000);
        }
    }

    private class MyItemTouchListener implements BaseRecycleView.OnItemTouchListener {
        @Override
        public void onClickListener(int position) {
            showToast(data.get(position));
        }

        @Override
        public void onLongClickListener(int position) {

        }
    }

    private void showToast(String s) {
        if (toast == null)
            toast = Toast.makeText(this, s, Toast.LENGTH_SHORT);
        else
            toast.setText(s);
        toast.show();
    }

    private class MenuItemClickListener implements Toolbar.OnMenuItemClickListener {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.linear_manager:
                    baseRecycleView.switchLayoutManager(linearLayoutManager);
                    break;

                case R.id.grid_manager:
                    baseRecycleView.switchLayoutManager(gridLayoutManager);
                    break;

                case R.id.staggered_manager:
                    baseRecycleView.switchLayoutManager(staggeredGridLayoutManager);
                    break;
            }
            return false;
        }
    }
}
