package com.gxg.administrator.mydemo7.dingbuxuanfu;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.gxg.administrator.mydemo7.R;
import com.gxg.administrator.mydemo7.headscroll.fragment.Head1Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DingBuXuanFuActivity extends AppCompatActivity {
    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.vp)
    ViewPager mVp;
    @Bind(R.id.coorlayout)
    CoordinatorLayout mCoorlayout;
    @Bind(R.id.appbar_layout)
    AppBarLayout mAppbarLayout;
    @Bind(R.id.title)
    TextView title;
//    @Bind(R.id.toolbar)
//    Toolbar toolbar;
    /**
     * app:layout_scrollFlags属性里面必须至少启用scroll这个flag，这样这个view才会滚动出屏幕，否则它将一直固定在顶部。可以使用的其他flag有：
     * enterAlways: 一旦向上滚动这个view就可见。
     * enterAlwaysCollapsed: 顾名思义，这个flag定义的是何时进入（已经消失之后何时再次显示）。假设你定义了一个最小高度（minHeight）同时enterAlways也定义了，那么view将在到达这个最小高度的时候开始显示，并且从这个时候开始慢慢展开，当滚动到顶部的时候展开完。
     * exitUntilCollapsed: 同样顾名思义，这个flag时定义何时退出，当你定义了一个minHeight，这个view将在滚动到达这个最小高度的时候消失。
     * 记住，要把带有scroll flag的view放在前面，这样收回的view才能让正常退出，而固定的view继续留在顶部
     */

    private String titles[] = {"最新", "价格", "热门", "筛选", "MFS", "时尚", "日记", "趋势"};
    private VpAdapter mAdapter;

    private int alfterverticalOffset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ding_bu_xuan_fu);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back_white_smoll);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_search://因为使用android.support.v7.widget.SearchView类，可以在
                        Snackbar.make(toolbar, "搜索", Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.action_share:
                        Snackbar.make(toolbar, "分享", Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.action_more:
                        Snackbar.make(toolbar, "更多", Snackbar.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        ButterKnife.bind(this);

        initFragment();

        mAppbarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                //控制下来
//                if (i == 0) {
//                    mSwipeRefreshLayout.setEnabled(true);
//                } else {
//                    mSwipeRefreshLayout.setEnabled(false);
//                }

            }
        });
    }

    List<Fragment> mFragments = new ArrayList<>();

    private void initFragment() {
        for (int i = 0; i < titles.length; i++) {
            Head1Fragment fragment = Head1Fragment.newInstance(titles[i]);
            mFragments.add(fragment);
        }

        if (titles.length > 4) {//条目多的话设置可以滑动
            mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        } else {//条目少的话设置一屏展示
            mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        }

        mAdapter = new VpAdapter(getSupportFragmentManager());
        mVp.setAdapter(mAdapter);

        mTabLayout.setupWithViewPager(mVp);


    }

    public class VpAdapter extends FragmentPagerAdapter {

        public VpAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
