package com.gxg.administrator.mydemo7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gxg.administrator.mydemo7.RefreshHeaderLayout.RefreshHeaderLayoutActivity;
import com.gxg.administrator.mydemo7.alivlayout.AliVLayoutActivity;
import com.gxg.administrator.mydemo7.allviewtouming.AllViewToumingActivity;
import com.gxg.administrator.mydemo7.colorfulline.ColorFullIneActivity;
import com.gxg.administrator.mydemo7.daojishi.DaoJiShiActivity;
import com.gxg.administrator.mydemo7.designtest.DesignTestActivity;
import com.gxg.administrator.mydemo7.dingbuxuanfu.DingBuXuanFuActivity;
import com.gxg.administrator.mydemo7.headscroll.HeadScrollActivity;
import com.gxg.administrator.mydemo7.iswiperefreshlayout.IRecycleviewActivity;
import com.gxg.administrator.mydemo7.okhttp.OkHttpActivity;
import com.gxg.administrator.mydemo7.pictures.PicturesActivity;
import com.gxg.administrator.mydemo7.pubuliu.RecycleViewDemo;
import com.gxg.administrator.mydemo7.pubuliuhead.MyPubuliuActivity;
import com.gxg.administrator.mydemo7.scrolldemo.ScrollDemoActivity;
import com.gxg.administrator.mydemo7.shijuexiaoguo.ShiJueTeXiaoActivity;
import com.gxg.administrator.mydemo7.tongzhilan.TongZhiLanActivity;
import com.gxg.administrator.mydemo7.webview.WebViewActivity;
import com.gxg.administrator.mydemo7.wxpwd.WxPwdActivity;
import com.gxg.administrator.mydemo7.yinying.YinYingActivity;
import com.gxg.administrator.mydemo7.zuolatiaozhuan.HomeActivity;
import com.gxg.administrator.mydemo7.zxing.ZXingActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.rv_pbl)
    TextView mRvPbl;
    @Bind(R.id.rv_head)
    TextView mRv;

    //修改

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



    }

    @OnClick({R.id.dingbu_xuanfu,R.id.all_view_touming,R.id.view_left_more,R.id.view_daojishi,R.id.view_shijuetexiao,R.id.view_wxpay,R.id.view_colorline,R.id.view_tongzhilan,R.id.view_addyinying,R.id.refresh_item,R.id.tv_headscroll,R.id.tv_design,R.id.tv_web,R.id.tv_okhttp, R.id.tv_scroll, R.id.iv_zxing, R.id.rv_pbl, R.id.rv_head, R.id.rv_ali, R.id.rv_fre_head, R.id.iv_picture})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rv_pbl:
                startActivity(new Intent(MainActivity.this, RecycleViewDemo.class));
                break;
            case R.id.rv_ali:
                startActivity(new Intent(MainActivity.this, AliVLayoutActivity.class));
                break;
            case R.id.rv_head:
                startActivity(new Intent(MainActivity.this, MyPubuliuActivity.class));
                break;
            case R.id.rv_fre_head:
                startActivity(new Intent(MainActivity.this, RefreshHeaderLayoutActivity.class));
                break;
            case R.id.iv_picture:
                startActivity(new Intent(MainActivity.this, PicturesActivity.class));
                break;
            case R.id.iv_zxing:
                startActivity(new Intent(MainActivity.this, ZXingActivity.class));
                break;
            case R.id.tv_scroll:
                startActivity(new Intent(MainActivity.this, ScrollDemoActivity.class));
                break;
            case R.id.tv_okhttp:
                startActivity(new Intent(MainActivity.this, OkHttpActivity.class));
                break;
            case R.id.tv_web:
                startActivity(new Intent(MainActivity.this, WebViewActivity.class));
                break;
            case R.id.tv_design:
                startActivity(new Intent(MainActivity.this, DesignTestActivity.class));
                break;
            case R.id.tv_headscroll:
                startActivity(new Intent(MainActivity.this, HeadScrollActivity.class));
                break;
            case R.id.refresh_item:
                startActivity(new Intent(MainActivity.this, IRecycleviewActivity.class));
                break;
            case R.id.view_addyinying:
                startActivity(new Intent(MainActivity.this, YinYingActivity.class));
                break;
            case R.id.view_tongzhilan:
                startActivity(new Intent(MainActivity.this, TongZhiLanActivity.class));
                break;
            case R.id.view_colorline:
                startActivity(new Intent(MainActivity.this, ColorFullIneActivity.class));
                break;
            case R.id.view_wxpay:
                startActivity(new Intent(MainActivity.this, WxPwdActivity.class));
                break;
            case R.id.view_shijuetexiao:
                startActivity(new Intent(MainActivity.this, ShiJueTeXiaoActivity.class));
                break;
            case R.id.view_daojishi:
                startActivity(new Intent(MainActivity.this, DaoJiShiActivity.class));
                break;
            case R.id.view_left_more:
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                break;
            case R.id.all_view_touming:
                startActivity(new Intent(MainActivity.this, AllViewToumingActivity.class));
                break;
            case R.id.dingbu_xuanfu:
                startActivity(new Intent(MainActivity.this, DingBuXuanFuActivity.class));
                break;

        }
    }
}
