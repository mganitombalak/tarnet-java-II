package com.tarnet.threading.filesizemeter;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(1);
        File file = new File("C:\\textDeneme");
        FileMeter fileMeter =  new FileMeter();
        AtomicLong size = new AtomicLong(0) ;
        Future<Long> f = service.submit(()->size.getAndAdd(fileMeter.getSize(file)));
        f.get();
        System.out.format("size: %d bytes", size.get());
    }
}
