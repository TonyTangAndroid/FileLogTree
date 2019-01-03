package io.github.android.tang.tony.file.logger.sample;

import android.app.Application;

import io.github.android.tang.tony.file.logger.FileLogger;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FileLogger.init(this);
    }
}
