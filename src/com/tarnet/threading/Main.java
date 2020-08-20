package com.tarnet.threading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by oguzhanaslan on 20.08.2020.
 */
public class Main {
    private static BlockingQueue queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {

        Thread Producer = new Thread(() -> {
            produce();
        });

        Thread Consumer = new Thread(() -> {
            consume();
        });

        Producer.start();
        Consumer.start();

        Producer.join();
        Consumer.join();
    }

    private static void produce() {
        Random random = new Random();
        while (true) {
            try {
                queue.put(random.nextInt(10));
            } catch (InterruptedException e) {
            }
        }
    }

    private static void consume() {
        while (true) {
            try {
                Thread.sleep(100);
                Integer value = (Integer) queue.take();
                System.out.print("Alınan: " + value + ", Kuyruğun boyutu: " + queue.size());
            } catch (InterruptedException e) {
            }
        }
    }
}
