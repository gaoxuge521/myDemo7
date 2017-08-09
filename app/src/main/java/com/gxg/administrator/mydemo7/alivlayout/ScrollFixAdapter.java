package com.gxg.administrator.mydemo7.alivlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.gxg.administrator.mydemo7.R;

/**
 * Created by lvliheng on 2017/8/9 at 13:41.
 */

public class ScrollFixAdapter extends DelegateAdapter.Adapter<ScrollFixAdapter.ScrollFixViewHolder> {

    private LayoutHelper mHelper;
    private Context mContext;
    private OnBackCliklistener mOnBackCliklistener;

    public ScrollFixAdapter(LayoutHelper helper, Context context) {
        mHelper = helper;
        mContext = context;
    }

    public void setOnBackCliklistener(OnBackCliklistener onBackCliklistener) {
        mOnBackCliklistener = onBackCliklistener;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @Override
    public ScrollFixViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ScrollFixViewHolder(LayoutInflater.from(mContext).inflate(R.layout.scroll_fix_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ScrollFixViewHolder holder, int position) {

        holder.back_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mOnBackCliklistener!=null){
                    mOnBackCliklistener.OnClick();
                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return 1;
    }

    public class ScrollFixViewHolder extends RecyclerView.ViewHolder{

        private ImageView back_top;
        public ScrollFixViewHolder(View itemView) {
            super(itemView);
            back_top = (ImageView) itemView.findViewById(R.id.back_top);
        }
    }

    public interface OnBackCliklistener{
        void OnClick();
    }
}
