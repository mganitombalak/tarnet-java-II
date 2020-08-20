package com.tarnet.threading.filesizemeter.calculate2;

import com.tarnet.threading.filesizemeter.StandartFileSizeCalculator;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class FileSizeCalculator2 {

    public static long calculate(final File file) {
        LongAdder totalSize = new LongAdder();
        if (file.isFile()) {
            totalSize.add(file.length());
        } else {
            final File[] subFiles = file.listFiles();
            if (subFiles != null) {
                Arrays.stream(subFiles).sequential().forEach(f -> totalSize.add(StandartFileSizeCalculator.calculate(f)));
            }
        }
        return totalSize.sum();
    }
}
