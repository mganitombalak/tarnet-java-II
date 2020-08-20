package com.tarnet.threading.filesizemeter.calculate2;

import com.tarnet.threading.filesizemeter.StandartFileSizeCalculator;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long size = StandartFileSizeCalculator.calculate(new File("C:\\tiftik"));
        long interval= System.currentTimeMillis()-startTime;
        System.out.printf("Calculation completed in %d ms: %d bytes",interval,size);
    }
}
