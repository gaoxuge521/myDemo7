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

import java.util.List;

/**
 * Created by gaoxuge on 2017/8/8 at 18:28.
 */

public class VlayoutAdapter extends DelegateAdapter.Adapter<VlayoutAdapter.VlayoutViewHolder> {


    private Context mContext;
    private List<ImgBean> mList;
    private LayoutHelper mHelper;

    public VlayoutAdapter(Context context, List<ImgBean> list, LayoutHelper helper) {
        this.mContext = context;
        this.mList = list;
        this.mHelper = helper;
    }

    public List<ImgBean> getList() {
        return mList;
    }


    public void setNewData(List<ImgBean> list){
        this.mList = list;
        notifyDataSetChanged();

    }
    public void addAll(List<ImgBean> list){
        this.mList.addAll(list);
        notifyDataSetChanged();

    };
    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @Override
    public VlayoutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VlayoutViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_img, parent, false));
    }

    @Override
    public void onBindViewHolder(VlayoutViewHolder holder, int position) {
        ViewGroup.LayoutParams params = holder.mImageView.getLayoutParams();
        params.height = mList.get(position).getHeight();
        holder.mImageView.setLayoutParams(params);


        holder.mImageView.setImageResource(mList.get(position).getImg());
        holder.mTextView.setText(mList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class VlayoutViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView mTextView;

        public VlayoutViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.item_img);
            mTextView = (TextView) itemView.findViewById(R.id.tv_ceshi);

        }
    }
}
