package com.tarnet.threading.pubsub;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            this.queue.put(getRandomBetweenRange(1, 10));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getRandomBetweenRange(int min, int max) {
        return (int) ((Math.random() * ((max - min) + 1)) + min);
    }
}
