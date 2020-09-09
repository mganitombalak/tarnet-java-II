package com.tarnet.anno;

import java.lang.reflect.Method;

public class AnnoMain {
    public static void main(String[] args) {
        Class<?> clazz = Awesome.class;

        Awesome aw = new Awesome();
        System.out.println("Class has TarimKrediDesc annotation:" + clazz.isAnnotationPresent(TarimKrediDesc.class));

        for (Method m : clazz.getDeclaredMethods()) {
            boolean hasAnnotation = m.isAnnotationPresent(TarimKrediDesc.class);
//            Functional.ConditionalInvoke(hasAnnotation,aw.f1(),aw.f2());
//            Functional.ConditionalInvoke(condition,aw);

            System.out.println(m.getName() + " method has annotation:" + (hasAnnotation ?
                    "true and value:" + m.getDeclaredAnnotation(TarimKrediDesc.class).value() :
                    "false"));
        }


//        if(condition){
//            f();
//        } else{
//            f2();
//        }
//
//        condition? f1():f2();

    }
}
