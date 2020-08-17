package com.tarnet.reflection;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;

public class reflection {

    public static void main(String[] args) throws ClassNotFoundException, ParseException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class personClass = Person.class;
//        Class personClass = Class.forName("com.tarnet.reflection.Person");

        System.out.println("Canonical Name:" + personClass.getCanonicalName());
        System.out.println("Package Name:" + personClass.getPackage().getName());
//        Person p = new Person(1,"Gani","Dev","01/01/1970");
//        System.out.println(p);

        Class[] personClassConstructorParams = {int.class, String.class, String.class, String.class};
        Constructor personClassConstructor = personClass.getConstructor(personClassConstructorParams);
        System.out.println("Constructon Parameter Count:" + personClassConstructor.getParameterCount());
        Object[] constructorArguments = new Object[4];
        constructorArguments[0] = 1;
        constructorArguments[1] = "Mehmet Gani";
        constructorArguments[2] = "Developer";
        constructorArguments[3] = "01/01/1980";

        Person p = (Person) personClassConstructor.newInstance(constructorArguments);
        System.out.println(p);
        System.out.println("=======Fields=======");

        Field[] personClassFields = personClass.getDeclaredFields();
        for(Field f:personClassFields){
            System.out.println("Name:"+f.getName());
        }

        System.out.println("=======Methods=======");
        Method[] personMethods = personClass.getDeclaredMethods();
        for (Method m : personMethods) {
            System.out.println("============================================");
            System.out.println("Name:" + m.getName());
            System.out.println("Class:" + m.getDeclaringClass());
            System.out.println("=======Parameters=======");
            Class[] parameters = m.getParameterTypes();
            for (Class param : parameters) {
                System.out.println(param.getName());
            }
            System.out.println("=======Exception Types=======");
            Class[] exceptionTypes =m.getExceptionTypes();
            for (Class et : exceptionTypes) {
                System.out.println(et.getName() + ":" + et.getTypeName());
            }
            System.out.println("=======Return Type=======");
            System.out.println("Returns:"+m.getReturnType());
            //Object returnValue= m.invoke(parameters);
        }
    }
}
