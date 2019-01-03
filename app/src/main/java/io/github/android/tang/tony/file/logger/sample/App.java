package io.github.android.tang.tony.file.logger.sample;

import android.app.Application;

import io.github.android.tang.tony.file.logger.LoggerUtil;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LoggerUtil.init(this);
    }
}
