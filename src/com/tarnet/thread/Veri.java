package com.tarnet.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Veri {

        Queue<Integer> producerVeri = new LinkedList<>();
        Queue<Integer> cosnumerVeri = new LinkedList();

        public Queue<Integer> getProducerVeri() {
                return producerVeri;
        }

        public void setProducerVeri(Queue<Integer> producerVeri) {
                this.producerVeri = producerVeri;
        }

        public Queue<Integer> getCosnumerVeri() {
                return cosnumerVeri;
        }

        public void setCosnumerVeri(Queue<Integer> cosnumerVeri) {
                this.cosnumerVeri = cosnumerVeri;
        }
}
