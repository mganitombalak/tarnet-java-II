package com.tarnet;

import com.tarnet.finale.Abst;
import com.tarnet.finale.B;
import com.tarnet.finale.C;
import com.tarnet.finale.IBase;
import com.tarnet.thread.ConsumerTh;
import com.tarnet.thread.ProducerTh;

import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
//        IBase obj = new C();
//        obj.print();
//        IBase bObj = new B();

//        S
//        O
//        L
//        I
//        D
        Stack<Integer> stack = new Stack<>();

        ConsumerTh thread1= new ConsumerTh(stack);
        ProducerTh thread2 = new ProducerTh(stack);
        ExecutorService executorSvc = Executors.newFixedThreadPool(3);
        ExecutorService executorSvc2 = Executors.newFixedThreadPool(5);
        Runnable producer = () -> {
            Thread A = new Thread(thread1);
            A.start();
        };
        Runnable consumer = () -> {
            Thread B = new Thread(thread2);
            B.start();
        };
        executorSvc.execute(producer);
        executorSvc2.execute(consumer);
        executorSvc.shutdown();
    }
}
