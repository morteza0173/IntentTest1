package com.intent.test.intenttest;

import android.app.Application;
import android.content.Context;

public class G extends Application {
    public static Context context;
    public static String name;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        name=context.getPackageName();



    }
}
