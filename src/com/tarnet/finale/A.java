package com.tarnet.finale;

// public final class A implements IBase { // Final classes can not be a subclass or cannot be derived
public class A extends Abst implements IBase {
    public final String A;// = "Class A";MUTABLE

    {
        A = "";
    }// Initializer Block

//    public A(String a) {
//        A = a;
//    }

    @Override
    public void DoSomething() {
        int[] arr = {2, 4, 6, 8};
        for (final int number:arr) { // final variable in this scope changes every iteration (redecleration)
            System.out.println(number);
        }
    }

    //    public final void DoA(){ final methods can not be overridden
    public void DoA() {

    }

    @Override
    void DoAbstractThings() {

    }
}
