package com.gxg.administrator.mydemo7.StickHeader;

import android.support.annotation.LayoutRes;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gxg.administrator.mydemo7.R;

/**
 * Created by sunger on 2017/10/15.
 */

public class CommonAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public CommonAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.textView, item);
    }


}
