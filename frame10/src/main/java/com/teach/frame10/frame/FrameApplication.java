package com.teach.frame10.frame;

import android.content.Context;

import com.yiyatech.utils.UtilsApplication;


public class FrameApplication extends UtilsApplication {
    public static FrameApplication mApplication;
    @Override
    public void onCreate() {
        super.onCreate();
    }


    public static FrameApplication getFrameApplication(){
        return mApplication;
    }

    public static Context getFrameApplicationContext(){
        return mApplication.getApplicationContext();
    }
}
