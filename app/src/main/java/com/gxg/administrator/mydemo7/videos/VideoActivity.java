package com.gxg.administrator.mydemo7.videos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gxg.administrator.mydemo7.R;
import com.gxg.administrator.mydemo7.videos.media.MediaHelp;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class VideoActivity extends AppCompatActivity {

    @Bind(R.id.rv)
    RecyclerView rv;
    private List<VideoBean> videoList = new ArrayList<>();
    private VideoAdapter videoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        initView();
        initData();
        initListener();

    }

    @Override
    protected void onPause() {
        super.onPause();
        MediaHelp.pause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        MediaHelp.resume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        MediaHelp.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        MediaHelp.release();

    }

    public void showToast(String string){
        Toast.makeText(VideoActivity.this,string,Toast.LENGTH_SHORT).show();
    }
    private void initListener() {

        videoAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.play_btn:

                        break;
                }
            }
        });

        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(rv.getScrollState()== RecyclerView.SCROLL_STATE_IDLE || !rv.isComputingLayout()){
                    if(videoAdapter.isPlaying){
                        videoAdapter.  indexPosition = -1;
                        videoAdapter. isPlaying = false;
                        videoAdapter.notifyDataSetChanged();
                        MediaHelp.release();
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        rv.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {

            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {

            }
        });

    }

    private void initData() {
        videoList.clear();
        for (int i = 0; i < VideoConstant.videoUrlList.length; i++) {
            VideoBean videoBean = new VideoBean();
            videoBean.setMp4(VideoConstant.videoUrlList[i]);
            videoBean.setName(VideoConstant.videosTitles[i]);
            videoBean.setImg(VideoConstant.videoThumbList[i]);
            videoList.add(videoBean);
        }


        rv.setLayoutManager(new LinearLayoutManager(this));
        videoAdapter = new VideoAdapter(new ArrayList<VideoBean>());
        rv.setAdapter(videoAdapter);
        videoAdapter.setNewData(videoList);


    }





    private void initView() {

    }


}
