package com.tarnet.threading.filesizemeter;

import lombok.SneakyThrows;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

public class FileMeter {
    AtomicLong atomicLong = new AtomicLong(0);
    ExecutorService service = Executors.newFixedThreadPool(5);


    long getSize(File file){


        addSize(file);

        return atomicLong.get() ;



    }

    @SneakyThrows
    private void addSize(File file){
        List<Future<Long>> futureList = new ArrayList<Future<Long>>();
        if(file.isDirectory()){
            for (File listFile : file.listFiles()) {
                futureList.add(service.submit(()->atomicLong.getAndAdd(getSize(listFile))));

            }
        }else{
            atomicLong.getAndAdd(file.length());
        }

        for (Future<Long> longFuture : futureList) {
            longFuture.get();
        }


    }
}
