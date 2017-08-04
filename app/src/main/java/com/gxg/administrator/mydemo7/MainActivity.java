package com.gxg.administrator.mydemo7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gxg.administrator.mydemo7.pubuliu.RecycleViewDemo;
import com.gxg.administrator.mydemo7.pubuliuhead.MyPubuliuActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.rv_pbl)
    TextView mRvPbl;
    @Bind(R.id.rv_head)
    TextView mRv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.rv_pbl, R.id.rv_head})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rv_pbl:
                startActivity(new Intent(MainActivity.this,RecycleViewDemo.class));
                break;
            case R.id.rv_head:
                startActivity(new Intent(MainActivity.this,MyPubuliuActivity.class));
                break;
        }
    }
}
