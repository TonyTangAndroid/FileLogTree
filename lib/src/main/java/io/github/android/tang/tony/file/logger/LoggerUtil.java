package io.github.android.tang.tony.file.logger;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.orhanobut.logger.CsvFormatStrategy;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.DiskLogStrategyProvider;
import com.orhanobut.logger.Logger;

import java.text.SimpleDateFormat;
import java.util.Locale;

import timber.log.Timber;

public class LoggerUtil {


    private LoggerUtil() {
        throw new RuntimeException();
    }

    public static void init(Context context) {
        init(context, Log.DEBUG);

    }

    @SuppressWarnings("SameParameterValue")
    static void init(Context context, final int logLevel) {
        Timber.plant(new FileLogTree(logLevel));
        Logger.addLogAdapter(new DiskLogAdapter(strategy(context)) {

            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                return LoggerUtil.isLoggable(priority, logLevel);
            }

        });

    }

    private static FormatStrategy strategy(Context context) {
        return CsvFormatStrategy.newBuilder().dateFormat(new SimpleDateFormat(" HH:mm:ss.SSS MM.dd.yyyy", Locale.US)).logStrategy(DiskLogStrategyProvider.get(context)).tag("").build();
    }

    static class FileLogTree extends Timber.DebugTree {

        private final int logLevel;

        public FileLogTree(int logLevel) {
            this.logLevel = logLevel;
        }

        @Override
        protected void log(int priority, String tag, @NonNull String message, Throwable t) {
            if (LoggerUtil.isLoggable(priority, logLevel)) {
                Logger.log(priority, tag, message, t);
            }
        }
    }

    private static boolean isLoggable(int priority, int logLevel) {
        return priority >= logLevel;
    }
}
