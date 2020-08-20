package com.tarnet.threading.pubsub;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

public class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;
    private ExecutorService executorService;
    private List<Integer> resultList;

    public Consumer(BlockingQueue<Integer> queue, ExecutorService executorService, List<Integer> resultList) {
        this.queue = queue;
        this.executorService = executorService;
        this.resultList = resultList;
    }

    @Override
    public void run() {
        while (true) {
            try {
                final int value = this.queue.take();
                this.executorService.execute(() -> {
                    this.resultList.add(value * value);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
