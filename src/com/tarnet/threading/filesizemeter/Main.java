package com.tarnet.threading.filesizemeter;

public class Main {
    public static void main(String[] args) {
        long totalSize = new FileMeter().getSize("C:\\");
    }
}
