package com.gxg.administrator.mydemo7.designtest;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gxg.administrator.mydemo7.R;

import java.util.List;

/**
 * Created by lvliheng on 2017/8/16 at 17:13.
 */

public class DesignAdapter extends BaseQuickAdapter<DesignBasebean,BaseViewHolder> {
    public DesignAdapter(@Nullable List<DesignBasebean> data) {
        super(R.layout.item_rv,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DesignBasebean item) {
        helper.setText(R.id.item_tv,item.getName());
       ImageView imageView =  helper.getView(R.id.item_iv);
//        imageView.setImageResource(item.getImg());
    }
}
