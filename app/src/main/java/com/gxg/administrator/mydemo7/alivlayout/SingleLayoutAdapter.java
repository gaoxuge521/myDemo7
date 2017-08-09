package com.gxg.administrator.mydemo7.alivlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.gxg.administrator.mydemo7.R;

/**
 * Created by lvliheng on 2017/8/9 at 9:45.
 */

public class SingleLayoutAdapter extends DelegateAdapter.Adapter<SingleLayoutAdapter.SingleLayoutViewHolder> {

    private LayoutHelper mHelper;
    private Context mContext;
    private SingleLayoutViewHolder mHolder;

    public SingleLayoutViewHolder getHolder() {
        return mHolder;
    }

    public SingleLayoutAdapter(LayoutHelper helper, Context context) {
        mHelper = helper;
        mContext = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @Override
    public SingleLayoutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mHolder = new SingleLayoutViewHolder(LayoutInflater.from(mContext).inflate(R.layout.ali_headview, parent, false));
        return mHolder;
    }

    @Override
    public void onBindViewHolder(SingleLayoutViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 1;
    }

    public class SingleLayoutViewHolder extends RecyclerView.ViewHolder{

        private ImageView img_head;
        private TextView tv_name;

        public ImageView getImg_head() {
            return img_head;
        }

        public TextView getTv_name() {
            return tv_name;
        }

        public SingleLayoutViewHolder(View itemView) {
            super(itemView);
            img_head = (ImageView) itemView.findViewById(R.id.ali_img_head);
            tv_name = (TextView) itemView.findViewById(R.id.ali_name_head);

        }
    }
}
