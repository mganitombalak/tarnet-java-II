package com.tarnet.threading.filesizemeter;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long size = StandartFileSizeCalculator.calculate(new File("C:\\Users\\mgani"));
        long interval = System.currentTimeMillis() - startTime;
        System.out.printf("STD Calculation completed in %d ms: %d bytes%n", interval, size);

        startTime = System.currentTimeMillis();
        size = ForkJoinFileSizeCalculator.calculate(new File("C:\\Users\\mgani"));
        interval = System.currentTimeMillis() - startTime;
        System.out.printf("FJ Calculation completed in %d ms: %d bytes%n", interval, size);
    }
}
