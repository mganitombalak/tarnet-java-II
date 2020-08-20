package com.tarnet.thread;

import java.util.*;

public class Veri {

        Stack<Integer> producerVeri = new Stack<>();
        Stack<Integer> cosnumerVeri = new Stack();

        public Stack<Integer> getProducerVeri() {
                return producerVeri;
        }

        public void setProducerVeri(Stack<Integer> producerVeri) {
                this.producerVeri = producerVeri;
        }

        public Stack<Integer> getCosnumerVeri() {
                return cosnumerVeri;
        }

        public void setCosnumerVeri(Stack<Integer> cosnumerVeri) {
                this.cosnumerVeri = cosnumerVeri;
        }
}
