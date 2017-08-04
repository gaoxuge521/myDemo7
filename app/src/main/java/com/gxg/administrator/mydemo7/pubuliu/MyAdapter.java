package com.gxg.administrator.mydemo7.pubuliu;

import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gxg.administrator.mydemo7.R;
import com.gxg.administrator.mydemo7.pubuliu.ImgBean;

import java.util.List;

/**
 * Created by lvliheng on 2017/8/1 at 17:48.
 */

public class MyAdapter extends BaseQuickAdapter<ImgBean,BaseViewHolder> {
    public MyAdapter(@Nullable List<ImgBean> data) {
        super(R.layout.item_img,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ImgBean item) {

       ImageView ivImage =  helper.getView(R.id.item_img);


        ViewGroup.LayoutParams params = ivImage.getLayoutParams();
        //设置图片的相对于屏幕的宽高比
        params.width = item.getWidth()/3;
        params.height = item.getHeight();
        ivImage.setLayoutParams(params);

        ivImage.setImageResource(item.getImg());
    }
}
