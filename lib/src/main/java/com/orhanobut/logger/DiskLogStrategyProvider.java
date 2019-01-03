package com.orhanobut.logger;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;

import java.io.File;

public class DiskLogStrategyProvider {

    private static final int MAX_BYTES = 500 * 1024; // 500K averages to a 4000 lines per file

    @NonNull
    public static DiskLogStrategy get(Context context) {
        String diskPath = context.getCacheDir().getAbsolutePath();
        String folder = diskPath + File.separatorChar + "logger";
        HandlerThread ht = new HandlerThread("AndroidFileLogger." + folder);
        ht.start();
        Handler handler = new DiskLogStrategy.WriteHandler(ht.getLooper(), folder, MAX_BYTES);
        return new DiskLogStrategy(handler);
    }


}
