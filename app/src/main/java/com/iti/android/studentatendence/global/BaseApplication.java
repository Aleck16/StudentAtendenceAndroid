package com.iti.android.studentatendence.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * 自定义Application
 * Created by Aleck_ on 2017/3/10.
 */

public class BaseApplication extends Application {

    private static Context context;
    private static int mainThreadId;
    private static Handler handler;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        mainThreadId = android.os.Process.myTid();    //获取当前主线程ID
        handler = new Handler();
    }

    public static Context getContext() {
        return context;
    }

    public static Handler getHandler() {
        return handler;
    }

    public static int getMainThreadId() {
        return mainThreadId;
    }
}
