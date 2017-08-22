package com.gxg.administrator.mydemo7.yinying;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gxg.administrator.mydemo7.R;
import com.wangjie.shadowviewhelper.ShadowProperty;
import com.wangjie.shadowviewhelper.ShadowViewDrawable;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.maning.library.zxing.utils.ZXingUtils.dip2px;

public class YinYingActivity extends AppCompatActivity {

    @Bind(R.id.ll_ll)
    LinearLayout mLlLl;
    @Bind(R.id.tv_tv)
    TextView mTvTv;
    @Bind(R.id.iv_iv)
    ImageView mIvIv;
    @Bind(R.id.view_view)
    TextView view_view;
    private ShadowProperty mSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yin_ying);
        ButterKnife.bind(this);

        //四周都有阴影
        allsideshadow();

        //左边下边有阴影
        onlyleftandtopsidesshadow();

        bottonAndRight();

        setbotton();
    }

    private void setbotton() {
        ShadowProperty sp = new ShadowProperty()
                .setShadowColor(0x77000000)
                .setShadowDy(dip2px(this,0.5f))
                .setShadowRadius(dip2px(this,3))
                .setShadowSide(ShadowProperty.BOTTOM);
        ShadowViewDrawable sd = new ShadowViewDrawable(sp,Color.RED,0,0);
        ViewCompat.setBackground(view_view,sd);
        ViewCompat.setLayerType(view_view, ViewCompat.LAYER_TYPE_SOFTWARE, null);
    }

    private void bottonAndRight() {
        ShadowProperty shadowProperty = new ShadowProperty()
                .setShadowColor(0x77FF0000)
                .setShadowDy(dip2px(this,0.5f))
                .setShadowRadius(dip2px(this,3))
                .setShadowSide(ShadowProperty.BOTTOM|ShadowProperty.RIGHT);
        ShadowViewDrawable shadowViewDrawable = new ShadowViewDrawable(shadowProperty,Color.TRANSPARENT,0,0);
        ViewCompat.setBackground(mIvIv,shadowViewDrawable);
        ViewCompat.setLayerType(mIvIv, ViewCompat.LAYER_TYPE_SOFTWARE, null);
    }

    private void onlyleftandtopsidesshadow() {
        ShadowProperty  mSp = new ShadowProperty()
                .setShadowColor(0x77FF0000)
                .setShadowDy(dip2px(this, 0.5f))
                .setShadowRadius(dip2px(this, 3))
                .setShadowSide(ShadowProperty.LEFT | ShadowProperty.BOTTOM);
        ShadowViewDrawable sd = new ShadowViewDrawable(mSp, Color.TRANSPARENT, 0, 0);
        ViewCompat.setBackground(mTvTv, sd);
        ViewCompat.setLayerType(mTvTv, ViewCompat.LAYER_TYPE_SOFTWARE, null);
    }

    private void allsideshadow() {
        // all sides shadow
        mSp = new ShadowProperty()
                .setShadowColor(0x77000000)
                .setShadowDy(dip2px(this, 0.5f))
                .setShadowRadius(dip2px(this, 3))
                .setShadowSide(ShadowProperty.ALL);
        ShadowViewDrawable sd = new ShadowViewDrawable(mSp, Color.WHITE, 0, 0);
        ViewCompat.setBackground(mLlLl, sd);
        ViewCompat.setLayerType(mLlLl, ViewCompat.LAYER_TYPE_SOFTWARE, null);
    }
}
