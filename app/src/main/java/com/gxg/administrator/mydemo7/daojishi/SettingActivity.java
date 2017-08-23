package com.gxg.administrator.mydemo7.daojishi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.gxg.administrator.mydemo7.R;

/**
 * Description：SettingActivity
 * Created by：CaMnter
 * Time：2016-03-17 17:20
 */
public class SettingActivity extends AppCompatActivity
    implements View.OnClickListener, EasyCountDownTextureView.EasyCountDownListener {

    private static final String TAG = "StyleActivity";
    private EasyCountDownTextureView countdownText;


    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_setting);
        this.countdownText = (EasyCountDownTextureView) this.findViewById(
            R.id.setting_countdown_text);
        this.findViewById(R.id.setting_hour_button).setOnClickListener(this);
        this.findViewById(R.id.setting_minute_button).setOnClickListener(this);
        this.findViewById(R.id.setting_second_button).setOnClickListener(this);
        this.findViewById(R.id.setting_start_button).setOnClickListener(this);
        this.findViewById(R.id.setting_stop_button).setOnClickListener(this);
        this.countdownText.setEasyCountDownListener(this);
    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.setting_hour_button:
                this.countdownText.setTimeHour(1);
                break;
            case R.id.setting_minute_button:
                this.countdownText.setTimeMinute(1);
                break;
            case R.id.setting_second_button:
                this.countdownText.setTimeSecond(1);
                break;
            case R.id.setting_start_button:
                this.countdownText.start();
                break;
            case R.id.setting_stop_button:
                this.countdownText.stop();
                break;
        }
    }


    /**
     * When count down start
     */
    @Override public void onCountDownStart() {
        Log.i(TAG, "[" + TAG + "]      [onCountDownStart]");
    }


    /**
     * When count down time error
     */
    @Override public void onCountDownTimeError() {

    }


    /**
     * When count down stop
     *
     * @param millisInFuture millisInFuture
     */
    @Override public void onCountDownStop(long millisInFuture) {
        Log.i(TAG, "[" + TAG + "]      [onCountDownStop]");
    }


    /**
     * When count down completed
     */
    @Override public void onCountDownCompleted() {

    }

}
