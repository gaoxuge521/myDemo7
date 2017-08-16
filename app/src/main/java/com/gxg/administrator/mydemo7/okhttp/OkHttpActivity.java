package com.gxg.administrator.mydemo7.okhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gxg.administrator.mydemo7.R;

public class OkHttpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);

        HttpHelper.getInstance().request( HttpHelper.url, new HttpHelper.HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.e("sss  onSuccess",result);
            }

            @Override
            public void onFailure(String msg) {
                Log.e("sss  onFailure",msg);
            }

            @Override
            public void onError(String msg) {
                Log.e("sss  onError",msg);
            }
        });
    }
}
