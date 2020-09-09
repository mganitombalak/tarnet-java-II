package com.tarnet.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainThread {
    public static void main(String[] args) {
        // CyclicBarrier vs Semaphore

        Semaphore semaphore = new Semaphore(3);

        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("Barrier execution completed."));

        BarrierCandidate firstBarrier = new BarrierCandidate(barrier);
        BarrierCandidate secondBarrier = new BarrierCandidate(barrier);
        BarrierCandidate thirdBarrier = new BarrierCandidate(barrier);
        BarrierCandidate fourthBarrier = new BarrierCandidate(barrier);

        new Thread(firstBarrier,"firstBarrier").start();
        new Thread(secondBarrier,"secondBarrier").start();
        new Thread(thirdBarrier,"thirdBarrier").start();
        new Thread(fourthBarrier,"fourthBarrier").start();
    }
}
