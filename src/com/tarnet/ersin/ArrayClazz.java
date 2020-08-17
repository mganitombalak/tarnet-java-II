package com.tarnet.ersin;

import java.util.Arrays;

public class ArrayClazz {

    private static int arraySize = 10;


    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        String[] stringArray = new String[arraySize];
        for (int i = 0; i < arraySize; i++) {
            stringArray[i] = String.class.newInstance();
        }
        System.out.println(Arrays.toString(stringArray));
    }


}
