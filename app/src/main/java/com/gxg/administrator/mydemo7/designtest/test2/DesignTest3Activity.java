package com.gxg.administrator.mydemo7.designtest.test2;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.gxg.administrator.mydemo7.R;
import com.gxg.administrator.mydemo7.dingbuxuanfu.DingBuXuanFuActivity;
import com.gxg.administrator.mydemo7.headscroll.fragment.Head1Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DesignTest3Activity extends AppCompatActivity {
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @Bind(R.id.deals_header_tab)
    TabLayout mTabLayout;
    @Bind(R.id.page)
    ViewPager mVp;
    @Bind(R.id.titleText)
    TextView titleText;

    private String titles[] = {"最新", "价格", "热门", "筛选", "MFS", "时尚", "日记", "趋势"};
    List<Fragment> mFragments = new ArrayList<>();
    private VpAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_test3);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        initFragment();

        addListener();
    }

    private void addListener() {

    }

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
}
