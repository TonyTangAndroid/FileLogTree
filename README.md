## A Timber log tree that writes log into files.


### How to use?

###### Step 1 : Plant the tree
```
    Timber.plant(new FileLogTree(this, Log.DEBUG));
```

###### Step 2 : Log your log
```
    Timber.d("This is a Timber debug log that will be saved into disk log file.");
    Timber.e("This is an Timber error log that will be saved into disk log file.");
    Timber.v("This is an Timber verbose log that will NOT be saved into disk log file.");
```

The log will be written into your **app cache directory**.

```
/data/data/io.github.android.tang.tony.file.logger.sample/cache/logger/logs_0.csv
```

The maximum size of log file is 500K(averages to a 4000 lines per file).
The default file name is **logs_```0```.csv**. If the log is larger than
this, it will generate a new file incrementally with **logs_```1```.csv**.


# Credit
This library is developed based on [logger](https://github.com/orhanobut/logger) by [orhanobut](https://github.com/orhanobut)
and [Timber](https://github.com/JakeWharton/timber) by [JakeWharton](https://github.com/JakeWharton).
