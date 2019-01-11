package io.github.android.tang.tony.file.logger.sample;

import android.app.Application;
import android.util.Log;

import io.github.android.tang.tony.file.logger.FileLogTree;
import timber.log.Timber;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new FileLogTree(this, Log.DEBUG));
    }
}
