package com.example.kimcy929.accessibilityservicesample;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by kimcy929 on 7/9/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
