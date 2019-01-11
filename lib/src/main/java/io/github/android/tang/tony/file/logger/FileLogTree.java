package io.github.android.tang.tony.file.logger;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.orhanobut.logger.CsvFormatStrategy;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.DiskLogStrategy;
import com.orhanobut.logger.DiskLogStrategyProvider;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;

import java.text.SimpleDateFormat;
import java.util.Locale;

import timber.log.Timber;

public class FileLogTree extends Timber.DebugTree {

    private final int logLevel;

    public FileLogTree(Context context, int logLevel) {
        this.logLevel = logLevel;
        Logger.addLogAdapter(new DiskLogAdapter(strategy(context)) {

            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                return loggable(priority, FileLogTree.this.logLevel);
            }

        });
    }


    static FormatStrategy strategy(Context context) {
        SimpleDateFormat format = new SimpleDateFormat(" HH:mm:ss.SSS MM.dd.yyyy", Locale.US);
        DiskLogStrategy diskLogStrategy = DiskLogStrategyProvider.get(context);
        return CsvFormatStrategy.newBuilder()
                .dateFormat(format)
                .logStrategy(diskLogStrategy).tag("").build();
    }

    static boolean loggable(int priority, int logLevel) {
        return priority >= logLevel;
    }

    @Override
    protected void log(int priority, String tag, @NonNull String message, Throwable t) {
        if (loggable(priority, logLevel)) {
            Logger.log(priority, tag, message, t);
        }
    }
}
