package com.gxg.administrator.mydemo7.StickHeader;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.gxg.administrator.mydemo7.R;

public class StickHeaderActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stick_header);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        tabLayout= (TabLayout) findViewById(R.id.tabLayout);
        toolbar.setTitle("美食");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager= (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addItem(new StickHeaderFragment(),"Tab1");
        viewPagerAdapter.addItem(new StickHeaderFragment(),"Tab2");
        viewPagerAdapter.addItem(new StickHeaderFragment(),"Tab3");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
