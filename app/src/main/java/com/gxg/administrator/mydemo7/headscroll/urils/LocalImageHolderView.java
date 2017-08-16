package com.gxg.administrator.mydemo7.headscroll.urils;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.gxg.administrator.mydemo7.R;

/**
 * Created by lvliheng on 2017/8/16 at 18:46.
 */

public class LocalImageHolderView implements Holder<String> {
    private ImageView imageView;
    @Override
    public View createView(Context context) {
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, final int position, String data) {
        Glide.with(context).load(data).placeholder(R.drawable.yidian_1167278123).error(R.drawable.yidian_1167278123).into(imageView);
    }
}
