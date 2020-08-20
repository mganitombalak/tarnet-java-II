package com.tarnet.threading.filesizemeter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicLong;

public class ForkJoinFileSizeCalculator {
    public static class FileSizeCalculatorTask extends RecursiveTask<Long> {
        private final File file;

        public FileSizeCalculatorTask(File file) {
            this.file = file;
        }

        @Override
        protected Long compute() {
            if (this.file.isFile()) {
                return this.file.length();
            } else {
                final List<FileSizeCalculatorTask> tasks = new ArrayList<>();
                final File[] subFiles = file.listFiles();
                if (subFiles != null) {
                    Arrays.stream(subFiles).forEach(f -> {
                        final FileSizeCalculatorTask fileTask = new FileSizeCalculatorTask(f);
                        fileTask.fork();
                        tasks.add(fileTask);
                    });
                }
                AtomicLong totalSize = new AtomicLong(0);
                tasks.forEach(t -> totalSize.addAndGet(t.join()));
                return  totalSize.get();
            }
        }
    }

    public static long calculate(final File file) {
        final ForkJoinPool fjPool = ForkJoinPool.commonPool();
        try {
            return fjPool.invoke(new FileSizeCalculatorTask(file));
        } finally {
            fjPool.shutdown();
        }
    }
}
