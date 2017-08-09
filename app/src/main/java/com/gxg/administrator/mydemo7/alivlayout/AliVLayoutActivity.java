package com.gxg.administrator.mydemo7.alivlayout;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ajguan.library.EasyRefreshLayout;
import com.ajguan.library.LoadModel;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
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
    @Bind(R.id.erl_easy)
    EasyRefreshLayout mErlEasy;
    private List<ImgBean> mImgBeanList = new ArrayList<>();


    private ImageView imghead;
    private TextView tvname;
    private SingleLayoutAdapter mSingleLayoutAdapter;
    private DelegateAdapter mDelegateAdapter;
    private VlayoutAdapter mAdapter;
    private VirtualLayoutManager mLayoutManager;
    private SingleLayoutHelper mSingleLayoutHelper;
    private StaggeredGridLayoutHelper mStaggeredGridLayoutHelper;
    private ImgBean mImgBean;
    private ImgBean mBean;
    private int mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ali_vlayout);
        ButterKnife.bind(this);
        initData();


        initRecycle();

        addlistener();

        setData();


    }

    private void setData() {
    }



    private void addlistener() {

        //防止第一行到顶部有空白区域
        mRvAli.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                //会重新计算布局
                VirtualLayoutManager manager = (VirtualLayoutManager) recyclerView.getLayoutManager();
                int firstVisibleItemPosition = manager.findFirstVisibleItemPosition();
                if(firstVisibleItemPosition==0){
                    mStaggeredGridLayoutHelper.checkForGaps();//防止第一行到顶部有空白区域
                }


            }

        });
        mErlEasy.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if(mCount>=80){
                            showToast("没有更多数据了。。。");
                            mErlEasy.loadMoreComplete();
                            mErlEasy.setLoadMoreModel(LoadModel.NONE);
                        }
                        mAdapter.addAll(getImgDate());
                        Toast.makeText(AliVLayoutActivity.this,"加载更多",Toast.LENGTH_SHORT).show();
                        mErlEasy.loadMoreComplete();
                    }
                },1000);
            }

            @Override
            public void onRefreshing() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mCount = 0;
                        mErlEasy.setLoadMoreModel(LoadModel.COMMON_MODEL);
                        mImgBeanList.clear();
                        mAdapter.getList().clear();
                        initData();
                        mAdapter.setNewData(mImgBeanList);

                        Toast.makeText(AliVLayoutActivity.this,"下拉加载",Toast.LENGTH_LONG).show();
                        mErlEasy.refreshComplete();
                    }
                },1000);
            }
        });
    }

    private boolean flag;
    private void initRecycle() {
        //设置Adapter列表
        List<DelegateAdapter.Adapter> adapters = new LinkedList<>();
        //绑定VirtualLayoutManager
        mLayoutManager = new VirtualLayoutManager(this);
        mRvAli.setLayoutManager(mLayoutManager);

       
        //设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）：
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRvAli.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(1, 20);

        mSingleLayoutHelper = new SingleLayoutHelper();
        mImgBean = new ImgBean();
        mImgBean.setImg(R.drawable.yidian_1167278123);
        mImgBean.setName("首次设置值");

        mBean = new ImgBean();
        mBean.setImg(R.drawable.yidian_1167278026);
        mBean.setName("关注设置的值");
        mSingleLayoutAdapter = new SingleLayoutAdapter(mSingleLayoutHelper,this, mImgBean);
        mSingleLayoutAdapter.setGuanzhuClick(new SingleLayoutAdapter.OnGuanzhuClick() {
            @Override
            public void guanzhu() {
               if(flag){
                   mSingleLayoutAdapter.setData(mImgBean);
                   flag=false;
               }else{
                   mSingleLayoutAdapter.setData(mBean);
                   flag=true;
               }

            }
        });
        adapters.add(mSingleLayoutAdapter);

        //设置滚动固定布局
        ScrollFixLayoutHelper scrollFixLayoutHelper = new ScrollFixLayoutHelper(ScrollFixLayoutHelper.BOTTOM_RIGHT,0,0);
        scrollFixLayoutHelper.setShowType(ScrollFixLayoutHelper.SHOW_ON_LEAVE);
        ScrollFixAdapter scrollFixAdapter = new ScrollFixAdapter(scrollFixLayoutHelper,this);
        scrollFixAdapter.setOnBackCliklistener(new ScrollFixAdapter.OnBackCliklistener() {
            @Override
            public void OnClick() {
//                showToast("返回顶部");
                mRvAli.smoothScrollToPosition(0);

            }
        });
        adapters.add(scrollFixAdapter);

        //添加Sticky布局
        StickyLayoutHelper stickyLayoutHelper = new StickyLayoutHelper();
        stickyLayoutHelper.setStickyStart(true);
        ScrollFixLayoutAdapter scrollFixLayoutAdapter = new ScrollFixLayoutAdapter(stickyLayoutHelper,this){
            @Override
            public void onBindViewHolder(ScrollViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
            }
        };
        scrollFixLayoutAdapter.setOnItemCliclistener(new ScrollFixLayoutAdapter.OnItemCliclistener() {
            @Override
            public void onclick(String name, int position) {
                showToast(name+"  "+position);
            }
        });
        adapters.add(scrollFixLayoutAdapter);

//       tvname  = mSingleLayoutAdapter.getHolder().getTv_name();
//        imghead = mSingleLayoutAdapter.getHolder().getImg_head();
        //添加瀑布流的helper
        mStaggeredGridLayoutHelper = new StaggeredGridLayoutHelper(3);

        mStaggeredGridLayoutHelper.setGap(20);
        mStaggeredGridLayoutHelper.setMarginLeft(20);
        mStaggeredGridLayoutHelper.setMarginRight(20);
        mStaggeredGridLayoutHelper.setMarginTop(20);
        mStaggeredGridLayoutHelper.setMarginBottom(50);
        mAdapter = new VlayoutAdapter(this, mImgBeanList, mStaggeredGridLayoutHelper);
        mAdapter.setItemClicklistener(new VlayoutAdapter.OnItemClicklistener() {
            @Override
            public void OnItemClick(int position) {
                showToast(mAdapter.getList().get(position).getName()+" "+position);
            }
        });
        adapters.add(mAdapter);



        mDelegateAdapter = new DelegateAdapter(mLayoutManager);
        mDelegateAdapter.setAdapters(adapters);
        mRvAli.setAdapter(mDelegateAdapter);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }


    public List<ImgBean> getImgDate(){
        List<ImgBean> list = new ArrayList<>();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        AliVLayoutActivity.this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int dex = mAdapter.getList().size();
        mCount = dex+20;

        for (int i = dex; i < mCount; i++) {
            ImgBean imgBean = new ImgBean();
            imgBean.setName("测试" + i);
            imgBean.setImg(R.drawable.yidian_1167278026);
            imgBean.setWidth(width);
            imgBean.setHeight((int) (200 + Math.random() * 200));
            list.add(imgBean);
        }
        return list;
    }


    public void showToast(String str){
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
    private void initData() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        AliVLayoutActivity.this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        for (int i = 0; i < 30; i++) {
            ImgBean imgBean = new ImgBean();
            imgBean.setName("测试" + i);
            imgBean.setImg(R.drawable.yidian_1167278026);
            imgBean.setWidth(width);
            imgBean.setHeight((int) (200 + Math.random() * 200));
            mImgBeanList.add(imgBean);
        }
    }
}
