package com.tarnet.threading.filesizemeter;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class StandartFileSizeCalculator {

    public static long calculate(final File file) {
        AtomicLong totalSize = new AtomicLong(0);
        if (file.isFile()) {
            totalSize.addAndGet(file.length());
        } else {
            final File[] subFiles = file.listFiles();
            if (subFiles != null) {
                Arrays.stream(subFiles).sequential().forEach(f -> totalSize.addAndGet(StandartFileSizeCalculator.calculate(f)));
            }
        }
        return totalSize.get();
    }
}
