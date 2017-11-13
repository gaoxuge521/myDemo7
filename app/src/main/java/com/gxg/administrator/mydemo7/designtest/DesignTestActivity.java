package com.gxg.administrator.mydemo7.designtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gxg.administrator.mydemo7.R;
import com.gxg.administrator.mydemo7.designtest.test2.DesignTest2Activity;
import com.gxg.administrator.mydemo7.designtest.test2.DesignTest3Activity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DesignTestActivity extends AppCompatActivity {

    @Bind(R.id.test1)
    TextView mTest1;
    @Bind(R.id.test2)
    TextView mTest2;
    @Bind(R.id.activity_design_test)
    RelativeLayout mActivityDesignTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_test);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.test3,R.id.test1, R.id.test2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.test1:
                startActivity(new Intent(DesignTestActivity.this,DesignTest1Activity.class));
                break;
            case R.id.test2:
                startActivity(new Intent(DesignTestActivity.this,DesignTest2Activity.class));
                break;
            case R.id.test3:
                startActivity(new Intent(DesignTestActivity.this,DesignTest3Activity.class));
                break;
        }
    }
}
