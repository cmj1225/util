package com.yiyatech.utils;

import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

public class UtilsApplication extends MultiDexApplication {
    private static UtilsApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static Context getUtilsApplicationContext(){
        return mApplication.getApplicationContext();
    }
}
