package com.gxg.administrator.mydemo7;

import android.app.Application;
import android.content.Context;


/**
 * Created by lvliheng on 2017/8/16 at 9:33.
 */

public class BaseApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

    }

    public static Context getInstance(){
       return context;
    }
}
