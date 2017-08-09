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
import com.gxg.administrator.mydemo7.pubuliu.ImgBean;

/**
 * Created by lvliheng on 2017/8/9 at 9:45.
 */

public class SingleLayoutAdapter extends DelegateAdapter.Adapter<SingleLayoutAdapter.SingleLayoutViewHolder> {

    private LayoutHelper mHelper;
    private Context mContext;
    private SingleLayoutViewHolder mHolder;
    private ImgBean mImgBean;
    private OnGuanzhuClick mGuanzhuClick;

    public void setGuanzhuClick(OnGuanzhuClick guanzhuClick) {
        mGuanzhuClick = guanzhuClick;
    }

    public SingleLayoutViewHolder getHolder() {
        return mHolder;
    }

    public SingleLayoutAdapter(LayoutHelper helper, Context context,ImgBean imgBean) {
        this.mHelper = helper;
        this.mImgBean = imgBean;
       this. mContext = context;
    }

    public void setData(ImgBean imgBean){
        this.mImgBean = imgBean;
        notifyDataSetChanged();
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
        holder.tv_name.setText(mImgBean.getName());
        holder.img_head.setImageResource(mImgBean.getImg());
        holder.guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mGuanzhuClick!=null){
                    mGuanzhuClick.guanzhu();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return 1;
    }

    public class SingleLayoutViewHolder extends RecyclerView.ViewHolder{

        private ImageView img_head;
        private TextView tv_name,guanzhu;



        public SingleLayoutViewHolder(View itemView) {
            super(itemView);
            img_head = (ImageView) itemView.findViewById(R.id.ali_img_head);
            tv_name = (TextView) itemView.findViewById(R.id.ali_name_head);
            guanzhu = (TextView) itemView.findViewById(R.id.guanzhu);

        }
    }

    public interface OnGuanzhuClick{
        void guanzhu();
    }
}
