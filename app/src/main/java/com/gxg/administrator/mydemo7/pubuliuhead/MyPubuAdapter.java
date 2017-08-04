package com.gxg.administrator.mydemo7.pubuliuhead;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gxg.administrator.mydemo7.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gaoxuge on 2017/8/4 at 15:20.
 */

public class MyPubuAdapter extends RecyclerView.Adapter<MyPubuAdapter.MyStaggeredViewHolder> {
    private List<String> mData;
    private Context mContext;
    private BaseRecycleView.OnItemTouchListener mListener;
    private Map<Integer, Integer> staggeredData = new HashMap<>();
    private MyStaggeredViewHolder sholder;

    public MyPubuAdapter( Context context) {
        this.mContext = context;
    }

    public List<String> getData() {
        return mData;
    }

    public void setData(List<String> data) {
        this.mData = data;
//        notifyDataSetChanged();
        Log.e("sss", "setData: "+mData.size() );
    }

    public void addData(List<String> list){
        this.mData.addAll(list);

    }

    public void setListener(BaseRecycleView.OnItemTouchListener listener) {
        this.mListener = listener;
    }


    public void clear(){
        mData.clear();
        notifyDataSetChanged();
    }
    @Override
    public MyStaggeredViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BaseRecycleView.TYPE_STAGGERED) {
            MyStaggeredViewHolder sholder = new MyStaggeredViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_staggered_view, parent, false));
            return sholder;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(MyStaggeredViewHolder holder, int position) {

        if (holder instanceof MyStaggeredViewHolder) {
            sholder = (MyStaggeredViewHolder) holder;
            sholder.position = position;
            sholder.txt.setText(mData.get(position));
            if (!staggeredData.containsKey(position))
                staggeredData.put(position, (int) (Math.random() * 100 + 151));//记住高度
            sholder.txt.setMinHeight(staggeredData.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }


    public class MyStaggeredViewHolder extends BaseRecycleView.BaseViewHolder {

        private TextView txt;

        public MyStaggeredViewHolder(View itemView) {
            super(itemView, mListener);
            txt = (TextView) itemView.findViewById(R.id.txt);
        }
    }
}
