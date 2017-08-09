package com.gxg.administrator.mydemo7.pubuliuhead;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

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

    public MyPubuAdapter( Context context,List<String> list) {
        this.mContext = context;
        this.mData = list;
    }

    public List<String> getData() {
        return mData;
    }

    public void setData(List<String> data) {
        this.mData = data;

        Log.e("sss", "setData: "+mData.size() );
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
        Log.e("sss","qqqqqqqqqqqqqqqqqqqq");
        if (viewType == BaseRecycleView.TYPE_STAGGERED) {
            MyStaggeredViewHolder sholder = new MyStaggeredViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_collection_new_detail_recycler_layout, parent, false));
            return sholder;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(MyStaggeredViewHolder holder, int position) {
        Log.e("sss","wwwwwwwwwwwwwwwwwwwwww");
        if (holder instanceof MyStaggeredViewHolder) {
            sholder = (MyStaggeredViewHolder) holder;
            sholder.position = position;
//            sholder.txt.setText(mData.get(position));
            if (!staggeredData.containsKey(position))
                staggeredData.put(position, (int) (Math.random() * 100 + 151));//记住高度
//            sholder.txt.setMinHeight(staggeredData.get(position));
//            sholder.mImageView.setImageResource(R.drawable.yidian_1167278026);
            ViewGroup.LayoutParams params = sholder.rl_layout.getLayoutParams();
            params.height = staggeredData.get(position);
            sholder.rl_layout.setLayoutParams(params);
        }
    }

    @Override
    public int getItemCount() {
        Log.e("sss","eeeeeeeee   "+mData.size());
        return mData == null ? 0 : mData.size();
    }


    public class MyStaggeredViewHolder extends BaseRecycleView.BaseViewHolder {

//        private TextView txt;
//        private ImageView mImageView;

        private RelativeLayout rl_layout;

        public MyStaggeredViewHolder(View itemView) {
            super(itemView, mListener);
            rl_layout = (RelativeLayout) itemView.findViewById(R.id.rl_layout);
//            txt = (TextView) itemView.findViewById(R.id.txt);
//            mImageView = (ImageView) itemView.findViewById(R.id.item_iv);
        }
    }
}
