package com.tarnet.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreClient implements Runnable {
    private Semaphore semaphore;
    public SemaphoreClient(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is waiting for barrier, limit is:" + semaphore.availablePermits());
            semaphore.tryAcquire(2, TimeUnit.MINUTES);
            System.out.println(Thread.currentThread().getName()+ " is done");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
