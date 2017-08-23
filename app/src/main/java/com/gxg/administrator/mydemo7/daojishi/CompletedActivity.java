package com.gxg.administrator.mydemo7.daojishi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.gxg.administrator.mydemo7.R;

/**
 * Description：CompletedActivity
 * Created by：CaMnter
 */

public class CompletedActivity extends AppCompatActivity
    implements EasyCountDownTextureView.EasyCountDownListener {

    private static final long WHITE_DURATION_TIME = 6 * 1000;
    private static final long YELLOW_DURATION_TIME = 12 * 1000;
    private static final String TAG = CompletedActivity.class.getSimpleName();


    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_completed);
        EasyCountDownTextureView whiteCountDownTextureView
            = (EasyCountDownTextureView) this.findViewById(R.id.completed_white_countdown_text);
        whiteCountDownTextureView.setTime(WHITE_DURATION_TIME);
        whiteCountDownTextureView.setEasyCountDownListener(this);
        whiteCountDownTextureView.start();

        EasyCountDownTextureView yellowCountDownTextureView
            = (EasyCountDownTextureView) this.findViewById(R.id.completed_yellow_countdown_text);
        yellowCountDownTextureView.setTime(YELLOW_DURATION_TIME);
        yellowCountDownTextureView.setEasyCountDownListener(this);
        yellowCountDownTextureView.start();
    }


    /**
     * When count down start
     */
    @Override public void onCountDownStart() {

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

    }


    /**
     * When count down completed
     */
    @Override public void onCountDownCompleted() {
        Toast.makeText(this, "[" + TAG + "]      [onCountDownCompleted]", Toast.LENGTH_LONG).show();
    }

}
