package com.gxg.administrator.mydemo7.chinaMap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.gxg.administrator.mydemo7.R;
import com.socks.library.KLog;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：Administrator on 2018/6/19 10:16
 * 邮箱：android_gaoxuge@163.com
 */
public class ChinaMapActivity extends AppCompatActivity {
    @Bind(R.id.address)
    TextView address;
    @Bind(R.id.mapView)
    MapView mapView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_china_map);
        ButterKnife.bind(this);
        mapView.setMapRes(R.raw.chinamap);
        mapView.loadMap();
        mapView.setOnMapItemListener(new MapView.OnMapItemListener() {
            @Override
            public void onItemClick(ProvinceItem item) {
                KLog.e("sss  11111"+item.toString());
                Toast.makeText(ChinaMapActivity.this,item.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}
