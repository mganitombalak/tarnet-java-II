package com.tarnet.thread.filesizemeter;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        double size = ( new File("C:\\").getTotalSpace() / (1024.0 * 1024 * 1024)) -(new File("C:\\").getUsableSpace() / (1024.0 * 1024 * 1024) );
        System.out.printf( "%.3f GB\n", size);
    }
}
