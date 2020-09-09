package com.tarnet.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierCandidate implements Runnable {
    private CyclicBarrier cyclicBarrier;

    public BarrierCandidate(CyclicBarrier barrier) {
        this.cyclicBarrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is waiting for barrier, limit is:" + cyclicBarrier.getNumberWaiting());
            cyclicBarrier.await ();
            System.out.println(Thread.currentThread().getName()+ " is done");
        } catch (BrokenBarrierException ex) {

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
