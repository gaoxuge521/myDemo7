package com.gxg.administrator.mydemo7.shichagundong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gxg.administrator.mydemo7.R;

public class ShiChaGunDongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shi_cha_gun_dong);
    }

    public void openVerticalSample(View view) {
        startActivity(new Intent(this, VerticalSampleActivity.class));
    }

    public void openHorizontalSample(View view) {
        startActivity(new Intent(this, HorizontalSampleActivity.class));
    }
    public void openContentSample(View view) {
        startActivity(new Intent(this, ParallaxEverywhereSample.class));
    }
}
