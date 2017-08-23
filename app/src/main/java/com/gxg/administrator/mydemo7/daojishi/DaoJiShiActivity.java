package com.gxg.administrator.mydemo7.daojishi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.gxg.administrator.mydemo7.R;
import com.gxg.administrator.mydemo7.daojishi.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DaoJiShiActivity extends AppCompatActivity {

    @Bind(R.id.main_rv)
    RecyclerView mMainRv;
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dao_ji_shi);
        ButterKnife.bind(this);


        initData();

        mAdapter = new MainAdapter(classes);
        mMainRv.setLayoutManager(new LinearLayoutManager(this));
        mMainRv.setAdapter(mAdapter);

        mMainRv.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Class c =mAdapter.getData().get(position);
                DaoJiShiActivity.this.startActivity(new Intent(DaoJiShiActivity.this, c));
            }
        });
    }

    List<Class> classes= new ArrayList<>();
    private void initData() {
        this.classes.add(ShowActivity.class);
        this.classes.add(SettingActivity.class);
        this.classes.add(CompletedActivity.class);
    }
}
