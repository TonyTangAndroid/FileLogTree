package io.github.android.tang.tony.file.logger.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timber.d("This is a Timber debug log that will be saved into disk log file.");
        Timber.e("This is an Timber error log that will be saved into disk log file.");
        Timber.v("This is an Timber verbose log that will NOT be saved into disk log file.");
    }
}
