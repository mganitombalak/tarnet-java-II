package com.tarnet.threading.filesizemeter;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long size =StandartFileSizeCalculator.calculate(new File("C:\\Users\\mgani\\Documents\\Test"));
        long interval= System.currentTimeMillis()-startTime;
        System.out.printf("Calculation completed in %d ms: %d bytes",interval,size);
    }
}
