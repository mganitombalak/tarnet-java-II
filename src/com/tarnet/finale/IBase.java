package com.tarnet.finale;

public interface IBase {

    void DoSomething();

    default void print(){ // Introduced in JAVA 8 Previous versions of java
        // must have abstract method
        System.out.println("Interface prints that words");
    }

    static void DoAwesomeThing(){ // can not be overridden
        System.out.println("Awesome things happened!");
    }
}
