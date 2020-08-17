package com.tarnet.finale;

public abstract class Abst {
    abstract void DoAbstractThings(); // Must be overridden in Derived Class

    void DoThings(){
        System.out.println("Thins get done by Abst");
    }
}
