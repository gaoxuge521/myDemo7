package com.gxg.administrator.mydemo7.designtest;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.gxg.administrator.mydemo7.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DesignTest1Activity extends AppCompatActivity {

    @Bind(R.id.btn)
    Button mBtn;
    @Bind(R.id.activity_design_test1)
    CoordinatorLayout mActivityDesignTest1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_test1);
        ButterKnife.bind(this);

        mBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_MOVE){
                    view.setX(event.getRawX()-view.getWidth()/2);
                    view.setY(event.getRawY()-view.getHeight()/2);
                }
                return true;
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
