package com.gxg.administrator.mydemo7.shimmer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gxg.administrator.mydemo7.R;
import com.gxg.administrator.mydemo7.shimmer.utils.BaseUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShimmerActivity extends AppCompatActivity {

    @Bind(R.id.tv_list)
    TextView tvList;
    @Bind(R.id.tv_grid)
    TextView tvGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shimmer);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_list, R.id.tv_grid})
    public void onViewClicked(View view) {
        Intent intent = new Intent(this, DemoActivity.class);
        switch (view.getId()) {
            case R.id.tv_list:
                intent.putExtra(DemoActivity.EXTRA_TYPE, BaseUtils.TYPE_SECOND_LIST);
                startActivity(intent);
                break;
            case R.id.tv_grid:
                intent.putExtra(DemoActivity.EXTRA_TYPE, BaseUtils.TYPE_SECOND_GRID);
                startActivity(intent);
                break;
        }
    }
}
