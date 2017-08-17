package com.gxg.administrator.mydemo7.headscroll.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gxg.administrator.mydemo7.R;
import com.gxg.administrator.mydemo7.headscroll.bean.HeadBean;

import java.util.List;

/**
 * Created by gapxuge on 2017/8/16 at 19:03.
 *
 */

public class FragmentScrollAdapter extends BaseQuickAdapter<HeadBean,BaseViewHolder>{

    public FragmentScrollAdapter(@Nullable List<HeadBean> data) {
        super(R.layout.item_fragment_head,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HeadBean item) {
       helper.setText(R.id.item_fm_title,item.getName());

       helper.addOnClickListener(R.id.item_fm_iv);
    }
}
