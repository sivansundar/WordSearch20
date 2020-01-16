package com.siv.wordsearch20;

import android.app.Application;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        setTheme(R.style.AppTheme);
    }
}
