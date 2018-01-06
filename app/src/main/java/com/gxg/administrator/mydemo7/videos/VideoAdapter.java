package com.gxg.administrator.mydemo7.videos;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gxg.administrator.mydemo7.R;
import com.gxg.administrator.mydemo7.videos.media.MediaHelp;
import com.gxg.administrator.mydemo7.videos.media.VideoSuperPlayer;

import java.util.List;

/**
 * 作者：Administrator on 2018/1/5 15:04
 * 邮箱：android_gaoxuge@163.com
 */
public class VideoAdapter extends BaseQuickAdapter<VideoBean,BaseViewHolder> {
    public  int indexPosition = -1;
    public  boolean isPlaying = false;
    public VideoAdapter(@Nullable List<VideoBean> data) {
        super(R.layout.list_video_item,data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final VideoBean item) {
        helper.setText(R.id.info_title,item.getName());
        ImageView icon = helper.getView(R.id.icon);
        Glide.with(mContext).load(item.getImg()).asBitmap().into(icon);
        final ImageView play_btn = helper.getView(R.id.play_btn);
        final VideoSuperPlayer videoSuperPlayer = helper.getView(R.id.layout_video_holder);
        if(indexPosition==helper.getAdapterPosition()){
            videoSuperPlayer.setVisibility(View.VISIBLE);
        }else{
            videoSuperPlayer.setVisibility(View.GONE);
            videoSuperPlayer.close();
        }


        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaHelp.release();
                indexPosition = helper.getAdapterPosition();
                isPlaying = true;
                videoSuperPlayer.setVisibility(View.VISIBLE);
                videoSuperPlayer.loadAndPlay(MediaHelp.getInstance(), item.getMp4(), 0, false);
                videoSuperPlayer.setVideoPlayCallback(new MyVideoPlayCallback(play_btn,videoSuperPlayer,item));
                notifyDataSetChanged();
            }
        });
    }

    class MyVideoPlayCallback implements  VideoSuperPlayer.VideoPlayCallbackImpl{
        ImageView mPlayBtnView;
        VideoSuperPlayer mSuperVideoPlayer;
        VideoBean info;

        public MyVideoPlayCallback(ImageView mPlayBtnView, VideoSuperPlayer mSuperVideoPlayer, VideoBean info) {
            this.mPlayBtnView = mPlayBtnView;
            this.mSuperVideoPlayer = mSuperVideoPlayer;
            this.info = info;
        }

        @Override
        public void onCloseVideo() {
            closeVideo();
        }

        @Override
        public void onSwitchPageType() {

        }

        @Override
        public void onPlayFinish() {
            closeVideo();
        }
        private void closeVideo() {
            isPlaying = false;
            indexPosition = -1;
            mSuperVideoPlayer.close();
            MediaHelp.release();
            mPlayBtnView.setVisibility(View.VISIBLE);
            mSuperVideoPlayer.setVisibility(View.GONE);
        }
    }
}
