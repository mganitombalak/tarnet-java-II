package com.tarnet.thread;

import com.tarnet.thread.consumer.Consumer;
import com.tarnet.thread.producer.Producer;
import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        Veri veri = new Veri() ;
        ExecutorService executorServicProducee = Executors.newFixedThreadPool(5);
        ExecutorService executorServiceConsume = Executors.newFixedThreadPool(5);
        Future futureP =  executorServicProducee.submit(new Producer(veri));
        Future futureP1 =  executorServicProducee.submit(new Producer(veri));
        Future futureP2 =  executorServicProducee.submit(new Producer(veri));
        Future futureC = executorServiceConsume.submit(new Consumer(veri));
        futureP.get();
        futureP1.get();
        futureP2.get();
        futureC.get();

    }
}
