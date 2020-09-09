package com.tarnet.boxing;

import java.util.ArrayList;
import java.util.List;

public class BoxinMain {
    public static void main(String[] args) {
        int x = 5;
        Integer y = new Integer(x); // <- Wrapper Class //Boxing

        List<Integer> intList = new ArrayList<>();
        intList.add(new Integer(1));
        intList.add(2); // <- intList.add(new Integer(2)) Autoboxing
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);

        System.out.println(x + y); // AutoUnboxing

        int z = y; // Unboxing

        // Narrowing
        Long a = new Long(5);
        //int b =  a.intValue(); // Unboxing
        Integer b = a.intValue(); //Autoboxing
        //short c = (short) b;
        short c = b.shortValue();//Unboxing

        // Widening
        short i= 5;
        int j = i;
        long k = j;

    }
}
