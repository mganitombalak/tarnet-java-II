package com.tarnet.reflection;

import java.lang.reflect.InvocationTargetException;

public class ArrayFactory<T> {

    private final Class<T> type;

    public ArrayFactory(Class<T> type) {
        this.type = type;
    }

    public Class<T> getMyType() {
        return this.type;
    }
    public  T[] createArray (int length) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class array = getMyType().getClass();
        Class[] ararrayLengtParaams = {int.class};
        Object[] constructorArguments = new Object[1];
        constructorArguments[0]=length;
        return (T[]) array.getConstructor(ararrayLengtParaams).newInstance(constructorArguments);


    }
}
