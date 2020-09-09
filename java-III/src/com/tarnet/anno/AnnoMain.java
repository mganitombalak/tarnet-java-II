package com.tarnet.anno;

import java.lang.reflect.Method;

public class AnnoMain {
    public static void main(String[] args) {
        Class<?> clazz = Awesome.class;

        System.out.println("Class has TarimKrediDesc annotation:" + clazz.isAnnotationPresent(TarimKrediDesc.class));

        for (Method m : clazz.getDeclaredMethods()) {
            boolean hasAnnotation = m.isAnnotationPresent(TarimKrediDesc.class);
            System.out.println(m.getName() + " method has annotation:" + (hasAnnotation ?
                    "true and value:" + m.getDeclaredAnnotation(TarimKrediDesc.class).value() :
                    "false"));
        }
    }
}
