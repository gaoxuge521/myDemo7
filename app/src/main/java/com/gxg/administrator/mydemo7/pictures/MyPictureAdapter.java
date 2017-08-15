package com.gxg.administrator.mydemo7.pictures;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gxg.administrator.mydemo7.R;
import com.jph.takephoto.model.TImage;

import java.io.File;
import java.util.List;

/**
 * Created by lvliheng on 2017/8/15 at 14:41.
 */

public class MyPictureAdapter extends BaseQuickAdapter<TImage,BaseViewHolder> {


    public MyPictureAdapter( @Nullable List<TImage> data) {
        super(R.layout.item_picture, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TImage item) {
        ImageView imageView = helper.getView(R.id.item_iv_picture);
        Glide.with(mContext).load(new File(item.getCompressPath())).into(imageView);
    }
}
