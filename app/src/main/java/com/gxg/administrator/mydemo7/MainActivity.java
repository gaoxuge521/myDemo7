package com.gxg.administrator.mydemo7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gxg.administrator.mydemo7.RefreshHeaderLayout.RefreshHeaderLayoutActivity;
import com.gxg.administrator.mydemo7.alivlayout.AliVLayoutActivity;
import com.gxg.administrator.mydemo7.pictures.PicturesActivity;
import com.gxg.administrator.mydemo7.pubuliu.RecycleViewDemo;
import com.gxg.administrator.mydemo7.pubuliuhead.MyPubuliuActivity;
import com.gxg.administrator.mydemo7.scrolldemo.ScrollDemoActivity;
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

    @OnClick({R.id.tv_scroll,R.id.iv_zxing,R.id.rv_pbl, R.id.rv_head,R.id.rv_ali,R.id.rv_fre_head,R.id.iv_picture})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rv_pbl:
                startActivity(new Intent(MainActivity.this,RecycleViewDemo.class));
                break;
            case R.id.rv_ali:
                startActivity(new Intent(MainActivity.this,AliVLayoutActivity.class));
                break;
            case R.id.rv_head:
                startActivity(new Intent(MainActivity.this,MyPubuliuActivity.class));
                break;
            case R.id.rv_fre_head:
                startActivity(new Intent(MainActivity.this,RefreshHeaderLayoutActivity.class));
                break;
            case R.id.iv_picture:
                startActivity(new Intent(MainActivity.this,PicturesActivity.class));
                break;
            case R.id.iv_zxing:
                startActivity(new Intent(MainActivity.this,ZXingActivity.class));
                break;
            case R.id.tv_scroll:
                startActivity(new Intent(MainActivity.this,ScrollDemoActivity.class));
                break;
        }
    }
}
