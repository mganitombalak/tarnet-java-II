package com.tarnet.nio;

import lombok.var;

public class Nio {
    public static void main(String[] args) {
        var fileReader = new FileReader("C:\\Users\\mgani\\Documents\\sample.txt");
//        fileReader.scannerReadData();
//        fileReader.fileReaderReadData();
        fileReader.fileInputStreamNIOReadData();
    }
}
