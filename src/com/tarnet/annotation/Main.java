package com.tarnet.annotation;

import lombok.var;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var credit = new Credit("Sulama");

        Class clazz = Credit.class;

        Arrays.stream(clazz.getDeclaredMethods()).sequential().forEach(m -> {
            System.out.println(m.getName() + (m.isAnnotationPresent(TarimKredi.class) ? " has TarimKredi annotation" : " has not"));
        });

    }
}
