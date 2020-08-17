package com.tarnet.okan;

import java.lang.reflect.Array;

public class main
{
    public static void main(String[] args) throws IllegalAccessException, InstantiationException
    {
        String[] arr = (String[])Array.newInstance(String.class, 5);
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = String.class.newInstance();
        }
    }
}
