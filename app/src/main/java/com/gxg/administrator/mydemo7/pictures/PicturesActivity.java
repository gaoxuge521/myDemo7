package com.gxg.administrator.mydemo7.pictures;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gxg.administrator.mydemo7.R;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoActivity;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.TImage;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.model.TakePhotoOptions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PicturesActivity extends TakePhotoActivity {

    @Bind(R.id.iv_img)
    ImageView mIvImg;
    @Bind(R.id.tv_xiangji)
    TextView mTvXiangji;
    @Bind(R.id.tv_xiangce)
    TextView mTvXiangce;
    @Bind(R.id.activity_pictures)
    RelativeLayout mActivityPictures;
    @Bind(R.id.rv_picture)
    RecyclerView mRvPicture;
    @Bind(R.id.et_selectsize)
    EditText mEtSelectsize;
    private TakePhoto mPhoto;


    private int limit = 4;//最多选择几张
    //裁剪时的宽高
    int height = 800;
    int width = 800;
    private Uri mImageUri;
    private MyPictureAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);
        ButterKnife.bind(this);


        initRecycleView();


        mPhoto = getTakePhoto();
    }

    private void initRecycleView() {
        mRvPicture.setLayoutManager(new LinearLayoutManager(PicturesActivity.this, LinearLayoutManager.HORIZONTAL, false));
        List<TImage> list = new ArrayList<>();
        mAdapter = new MyPictureAdapter(list);
        mRvPicture.setAdapter(mAdapter);
    }

    //设置公共的属性
    public void setAllParmeter() {
        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
        mImageUri = Uri.fromFile(file);


        configCompress(mPhoto);
        configTakePhotoOption(mPhoto);
    }

    private void gopicture() {
        setAllParmeter();
        //设置选择的图片的多少和裁剪的属性
        String string = mEtSelectsize.getText().toString();
        if(!TextUtils.isEmpty(string)){
            limit = Integer.valueOf(string);
        }else{
            limit = 1;
        }
        if (limit > 1) {
            mPhoto.onPickMultipleWithCrop(limit, getCropOptions());
            return;
        }


        //只设置选择图片的数量，不裁剪
//        mPhoto.onPickMultiple(limit);


//        //从文件夹选择带裁剪
//        mPhoto .onPickFromDocumentsWithCrop(imageUri,getCropOptions());
//        //从文件夹选择不带裁剪
//        mPhoto.onPickFromDocuments();

        //从相册选择带裁剪
        mPhoto.onPickFromGalleryWithCrop(mImageUri, getCropOptions());
        //从相册选择不带裁剪
//        mPhoto.onPickFromGallery();
    }

    //设置
    private void configTakePhotoOption(TakePhoto takePhoto) {
        TakePhotoOptions.Builder builder = new TakePhotoOptions.Builder();

        //使用takephoto自带相册//false使用系统的
        builder.setWithOwnGallery(true);


        //纠正拍照的照片的旋转角度
        builder.setCorrectImage(true);

        takePhoto.setTakePhotoOptions(builder.create());

    }

    //压缩的配置
    private void configCompress(TakePhoto takePhoto) {

        //不压缩
//        takePhoto.onEnableCompress(null,false);
//        return ;


        int maxSize = 102400;
        int width = 800;
        int height = 800;
        //显示压缩进度条
        boolean showProgressBar = true;
        //拍照压缩后是否保存原图
        boolean enableRawFile = true;

//        CompressConfig config;

        //压缩工具使用自带的
        CompressConfig config = new CompressConfig.Builder()
                .setMaxSize(maxSize)
                .setMaxPixel(width >= height ? width : height)
                .enableReserveRaw(enableRawFile)
                .create();

        //压缩工具使用LuBan
//        LubanOptions option=new LubanOptions.Builder()
//                .setMaxHeight(height)
//                .setMaxWidth(width)
//                .setMaxSize(maxSize)
//                .create();
//        config=CompressConfig.ofLuban(option);
//        config.enableReserveRaw(enableRawFile);

        takePhoto.onEnableCompress(config, showProgressBar);
    }

    //设置裁剪功能的属性
    private CropOptions getCropOptions() {
        CropOptions.Builder builder = new CropOptions.Builder();

//        builder.setAspectX(width).setAspectY(height);//宽*高
        builder.setOutputX(width).setOutputY(height);//宽/高

        builder.setWithOwnCrop(true);//true使用takephoto自带的裁剪工具  false使用系统的裁剪工具
        return builder.create();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.tv_xiangji, R.id.tv_xiangce})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_xiangji:
                goPhoto();
                break;
            case R.id.tv_xiangce:
                gopicture();
                break;
        }
    }

    private void goPhoto() {
        setAllParmeter();
        //从相机进带裁剪
        mPhoto.onPickFromCaptureWithCrop(mImageUri, getCropOptions());
        //从相机进不带裁剪
//        mPhoto.onPickFromCapture(mImageUri);
    }

    @Override
    public void takeCancel() {
        super.takeCancel();

    }

    @Override
    public void takeFail(TResult result, String msg) {
        super.takeFail(result, msg);
    }

    @Override
    public void takeSuccess(TResult result) {
        super.takeSuccess(result);
        showImg(result.getImages());
    }

    private void showImg(ArrayList<TImage> images) {
        Log.e("sss", images.toString());
        Log.e("sss", images.size() + "  ");

        if (images.size() == 1) {
            Log.e("sss", "size==1");
            mIvImg.setVisibility(View.VISIBLE);
            mRvPicture.setVisibility(View.GONE);
            Glide.with(PicturesActivity.this).load(new File(images.get(0).getCompressPath())).into(mIvImg);

        } else if (images.size() > 1) {
            mIvImg.setVisibility(View.GONE);
            mRvPicture.setVisibility(View.VISIBLE);
            mAdapter.setNewData(images);
            Log.e("sss", "size>1");
        } else {
            Log.e("sss", "........");
        }
    }

}
