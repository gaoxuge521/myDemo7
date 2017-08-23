package com.gxg.administrator.mydemo7.daojishi.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gxg.administrator.mydemo7.R;

import java.util.List;

/**
 * Description：MainAdapter
 * Created by：CaMnter
 * Time：2016-03-18 13:21
 */
public class MainAdapter extends BaseQuickAdapter<Class,BaseViewHolder> {
    public MainAdapter(@Nullable List<Class> data) {
        super(R.layout.item_main,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Class item) {
        helper.setText(R.id.main_item_tv,item.getSimpleName());
    }


}
