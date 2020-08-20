package com.tarnet.thread.consumer;

import com.tarnet.thread.Veri;
import lombok.SneakyThrows;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {

    Veri veri ;

    public Consumer(Veri veri) {
        this.veri = veri;
    }

    @SneakyThrows
    @Override
    public void run() {
        consume();

    }

    public void consume() throws InterruptedException {
        while(true){

            synchronized (this.veri) {
                if(veri.getProducerVeri().size()>0){
                    consumeEt();
                }
               else
                   Thread.sleep(500);

            }





        }


    }
    public void consumeEt(){
        veri.getCosnumerVeri().add(veri.getProducerVeri().pop()*2);
    }

    public Veri getVeri() {
        return veri;
    }

    public void setVeri(Veri veri) {
        this.veri = veri;
    }




}
