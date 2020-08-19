package com.tarnet.nio;

import lombok.var;

//import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Nio {
    public static void main(String[] args) {
        var fileReader = new FileReader("C:\\Users\\mgani\\Documents\\server.log");
//        fileReader.scannerReadData();
//        fileReader.fileReaderReadData();
//        fileReader.copyFileNIO("C:\\Users\\mgani\\Documents\\server-copy.log");

//        Path p = Paths.get("C:\\Users\\mgani\\Documents\\","server.log");

//        Path currentDirectory = Paths.get("C:\\Users\\mgani\\Documents\\Github\\tarnet-java-II\\");
//        System.out.println(currentDirectory.toAbsolutePath());
//        System.out.println(currentDirectory.getParent().toAbsolutePath());

//        Path currentDirectory = Paths.get("C:\\Users\\mgani\\.\\..\\tarnet-java-II\\");
//
//        System.out.println(currentDirectory.normalize());

        fileReader.asyncFileChannelReadData2();

    }
}
