package com.gxg.administrator.mydemo7.alivlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.gxg.administrator.mydemo7.R;

/**
 * Created by gaoxuge on 2017/8/9 at 13:13.
 *
 */

public class ScrollFixLayoutAdapter extends DelegateAdapter.Adapter<ScrollFixLayoutAdapter.ScrollViewHolder> {

    private LayoutHelper mHelper;
    private Context mContext;

    public ScrollFixLayoutAdapter(LayoutHelper helper, Context context) {
        mHelper = helper;
        mContext = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @Override
    public ScrollViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ScrollViewHolder(LayoutInflater.from(mContext).inflate(R.layout.scroll_fix_layout,parent,false));

    }

    @Override
    public void onBindViewHolder(ScrollViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ScrollViewHolder extends RecyclerView.ViewHolder{
        private RadioGroup mGroup;
        private RadioButton rb_zuixin,rb_jiage,rb_remen,rb_shaixuan;

        public RadioGroup getGroup() {
            return mGroup;
        }

        public RadioButton getRb_zuixin() {
            return rb_zuixin;
        }

        public RadioButton getRb_jiage() {
            return rb_jiage;
        }

        public RadioButton getRb_remen() {
            return rb_remen;
        }

        public RadioButton getRb_shaixuan() {
            return rb_shaixuan;
        }

        public ScrollViewHolder(View itemView) {
            super(itemView);
            mGroup = (RadioGroup) itemView.findViewById(R.id.rg_scro);
            rb_zuixin = (RadioButton) itemView.findViewById(R.id.rb_zuixin);
            rb_jiage = (RadioButton) itemView.findViewById(R.id.rb_jiage);
            rb_remen = (RadioButton) itemView.findViewById(R.id.rb_remen);
            rb_shaixuan = (RadioButton) itemView.findViewById(R.id.rb_shaixuan);
        }
    }
}
