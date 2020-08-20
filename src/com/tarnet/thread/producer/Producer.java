package com.tarnet.thread.producer;

import com.tarnet.thread.Veri;
import lombok.SneakyThrows;

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements  Runnable {
    Veri veri ;

    public Producer(Veri veri) {
        this.veri = veri;
    }



    @SneakyThrows
    @Override
    public void run() {
        produce();
    }

    public void produce() throws InterruptedException {
        while(true){
            int randomNum = ThreadLocalRandom.current().nextInt(1, 9);
            synchronized (this.veri) {
                veri.getProducerVeri().add(randomNum);

            }

            if(randomNum==5)
                break;

            Thread.sleep(1000);



        }
    }

    public Veri getVeri() {
        return veri;
    }

    public void setVeri(Veri veri) {
        this.veri = veri;
    }
}
