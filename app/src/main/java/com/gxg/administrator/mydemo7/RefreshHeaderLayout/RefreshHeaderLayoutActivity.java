package com.gxg.administrator.mydemo7.RefreshHeaderLayout;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gxg.administrator.mydemo7.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RefreshHeaderLayoutActivity extends AppCompatActivity {

    @Bind(R.id.toolbar_title)
    TextView mToolbarTitle;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.comment_list_merchandise_comment_tab_title_tv)
    TextView mCommentListMerchandiseCommentTabTitleTv;
    @Bind(R.id.comment_list_merchandise_comment_tab_strip)
    View mCommentListMerchandiseCommentTabStrip;
    @Bind(R.id.comment_list_merchandise_comment_tab)
    RelativeLayout mCommentListMerchandiseCommentTab;
    @Bind(R.id.comment_list_brand_comment_tab_title_tv)
    TextView mCommentListBrandCommentTabTitleTv;
    @Bind(R.id.comment_list_brand_comment_tab_strip)
    View mCommentListBrandCommentTabStrip;
    @Bind(R.id.comment_list_brand_comment_tab)
    RelativeLayout mCommentListBrandCommentTab;
    @Bind(R.id.appbar)
    AppBarLayout mAppbar;
    @Bind(R.id.comment_list_view_pager)
    CustomViewPager mCommentListViewPager;
    @Bind(R.id.main_content)
    CoordinatorLayout mMainContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_header_layout);
        ButterKnife.bind(this);
    }
}
