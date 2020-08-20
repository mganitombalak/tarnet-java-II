package com.tarnet.threading.pubsub;

import lombok.var;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args) {

        var results = new ArrayList<Integer>();
        var syncResults = Collections.synchronizedList(results);
        var queue = new LinkedBlockingDeque<Integer>(5000);

        var consumerExecutorService = Executors.newFixedThreadPool(5);
        var producerExecutorService = Executors.newFixedThreadPool(10);

        var producerTimer = new Timer();
        producerTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                producerExecutorService.execute(new Producer(queue));
            }
        }, 0, 1);


        var consumer = new Consumer(queue, consumerExecutorService, syncResults);
        consumerExecutorService.execute(consumer);


        var monitor = new Timer();
        monitor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.printf("Total:%s%n", syncResults.size());
            }
        }, 1000, 3000);
    }
}
