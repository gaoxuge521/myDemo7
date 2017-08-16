package com.gxg.administrator.mydemo7.headscroll.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gxg.administrator.mydemo7.headscroll.view.HeaderViewPagerFragment;

import java.util.List;

/**
 * Created by lvliheng on 2017/8/16 at 19:33.
 */

public class HeadFmPagerAdapter extends FragmentPagerAdapter {
    String[] titles;
    List<HeaderViewPagerFragment> fragments;
    public HeadFmPagerAdapter(FragmentManager fm, String[] titles, List<HeaderViewPagerFragment> fragments) {
        super(fm);
        this.titles = titles;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
